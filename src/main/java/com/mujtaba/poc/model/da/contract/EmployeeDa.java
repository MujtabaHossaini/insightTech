package com.mujtaba.poc.model.da.contract;

import com.mujtaba.poc.model.entity.Employee;

import java.util.List;

public interface EmployeeDa {

    public Employee getEmployeeById(int id);
    public Employee insertEmployee(Employee employee);
    public void deleteEmployee(int id);
    public void updateEmployee(int id, Employee newInfo);
    public List<Employee> getAllEmployees();
    public List<Employee> getAllEmployeesByDepartment(String department);

    public boolean checkUserNameExist(String username);
    public boolean checkEmailExist(String email);
    public Employee checkForLogin(Employee employee);


}
