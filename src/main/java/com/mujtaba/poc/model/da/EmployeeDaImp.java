package com.mujtaba.poc.model.da;

import com.mujtaba.poc.model.da.contract.EmployeeDa;
import com.mujtaba.poc.model.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaImp implements EmployeeDa {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee getEmployeeById(int id) {
        Query query = entityManager.createQuery("select e from Employee e where id =: id")
                                   .setParameter("id", id);
        return (Employee) query.getSingleResult();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        try {
            entityManager.persist(employee);
            return employee;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee e where e.id =: id")
                                   .setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateEmployee(int id, Employee newInfo) {
        Query query = entityManager.createQuery("update Employee e set " +
                "e.firstname = ?1," +
                "e.lastname = ?2," +
                "e.email = ?3," +
                "e.phone = ?4," +
                "e.department = ?5," +
                "e.birth_date = ?6 where e.id = ?7");
        query.setParameter(1, newInfo.getFirstname());
        query.setParameter(2, newInfo.getLastname());
        query.setParameter(3, newInfo.getEmail());
        query.setParameter(4, newInfo.getPhone());
        query.setParameter(5, newInfo.getDepartment());
        query.setParameter(6, newInfo.getBirth_date());
        query.setParameter(7, id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("select e from Employee e ");
        return query.getResultList();
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        Query query = entityManager.createQuery("select e from Employee e where e.department =: department")
                .setParameter("department", department);
        return query.getResultList();
    }

    @Override
    public boolean checkUserNameExist(String username) {
        return false;
    }

    @Override
    public boolean checkEmailExist(String email) {
        return false;
    }

    @Override
    public Employee checkForLogin(Employee employee) {
        return null;
    }
}
