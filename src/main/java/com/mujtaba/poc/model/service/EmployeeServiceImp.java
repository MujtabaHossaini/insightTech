package com.mujtaba.poc.model.service;

import com.mujtaba.poc.model.da.contract.EmployeeDa;
import com.mujtaba.poc.model.entity.Employee;
import com.mujtaba.poc.model.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDa employeeDa;


    @Override
    public Employee getEmployeeById(int id) {
        return employeeDa.getEmployeeById(id);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeDa.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDa.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(int id, Employee newInfo) {
        employeeDa.updateEmployee(id, newInfo);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDa.getAllEmployees();
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeDa.getAllEmployeesByDepartment(department);
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
