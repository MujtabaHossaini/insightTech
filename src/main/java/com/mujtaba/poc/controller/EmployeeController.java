package com.mujtaba.poc.controller;

import com.mujtaba.poc.model.entity.Employee;
import com.mujtaba.poc.model.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @InitBinder
    protected void initDataBinder(WebDataBinder webDataBinder)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }

    @RequestMapping(value = "/regform")
    public String showRegForm()
    {
        return "/auth/register";
    }

    @RequestMapping(value = "/register")
    public String registerEmployee(Employee employee, Model model)
    {
        if(employeeService.insertEmployee(employee) != null) {
            model.addAttribute("msg", "hame chi khobe");
            return "redirect:/employee/list-employees";
        }
        else {
            model.addAttribute("msg", "che bad heif shod akhey");
            return "/auth/fail";
        }
    }

    @RequestMapping(value = "/register-param",
            method = RequestMethod.GET,
            params = {
                    "firstname",
                    "lastname",
                    "phone",
                    "email",
                    "department",
                    "birthDate"})
    @ResponseBody
    public String registerEmployeeParam(
                                      @RequestParam(value = "firstname") String firstname,
                                      @RequestParam(value = "lastname") String lastname,
                                      @RequestParam(value = "phone") String phone,
                                      @RequestParam(value = "email") String email,
                                      @RequestParam(value = "department") String department,
                                      @RequestParam("birthDate") String birth_date) throws ParseException {
        Employee employee = new Employee(firstname, lastname,
                new SimpleDateFormat("yyyy-MM-dd").parse(birth_date), phone, email, department);
        if(employeeService.insertEmployee(employee) != null) {
            return "register succeed";
        }
        else {
            return "fail shod!";
        }
    }


    @RequestMapping(value = "/get-employee",
                    method = {RequestMethod.GET, RequestMethod.POST},
                    params = {"id"},
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> getEmployee(@RequestParam(value = "id", defaultValue = "0") String id)
    {
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("firstname", employee.getFirstname());
        stringMap.put("lastname", employee.getLastname());
        stringMap.put("phone", employee.getPhone());
        stringMap.put("email", employee.getEmail());
        stringMap.put("department", employee.getDepartment());
        stringMap.put("birth-date", employee.getBirth_date().toString());
        return stringMap;
    }

    @RequestMapping(value = "/list-employees-json",
                    method = {RequestMethod.GET, RequestMethod.POST},
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Map<String, String >> getEmployeesJson()
    {
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<Map<String, String >> maps = new LinkedList<>();
        employeeList.stream().forEach((employee)->{
            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("firstname", employee.getFirstname());
            stringMap.put("lastname", employee.getLastname());
            stringMap.put("phone", employee.getPhone());
            stringMap.put("email", employee.getEmail());
            stringMap.put("department", employee.getDepartment());
            stringMap.put("birth-date", employee.getBirth_date().toString());
            maps.add(stringMap);
        });
        return maps;
    }

    @RequestMapping(value = "/list-employees")
    public String listEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "/auth/list-employees";
    }

    @RequestMapping(value = "/list-department-employee",
                    method = {RequestMethod.GET, RequestMethod.POST},
                    params = {"department"})
    public String listDepartmentEmployees(Model model, @RequestParam("department") String department)
    {
        model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(department));
        return "/auth/list-employees";
    }

    @RequestMapping(value = "/list-department-employee-json",
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"department"})
    @ResponseBody
    public List<Map<String, String >> listDepartmentEmployeesJson(@RequestParam("department") String department)
    {
        List<Employee> employeeList = employeeService.getAllEmployeesByDepartment(department);
        List<Map<String, String >> maps = new LinkedList<>();
        employeeList.stream().forEach((employee)->{
            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("firstname", employee.getFirstname());
            stringMap.put("lastname", employee.getLastname());
            stringMap.put("phone", employee.getPhone());
            stringMap.put("email", employee.getEmail());
            stringMap.put("department", employee.getDepartment());
            stringMap.put("birth-date", employee.getBirth_date().toString());
            maps.add(stringMap);
        });
        return maps;
    }


    @RequestMapping(value = "/delete/{id:[0-9]+}",
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteEmployee(@PathVariable("id") String id)
    {
        employeeService.deleteEmployee(Integer.parseInt(id));
        return "redirect:/employee/list-employees";
    }

    @RequestMapping(value = "/delete-employee",
            method = {RequestMethod.GET, RequestMethod.POST},
                      params = {"id"})
    public String deleteEmployee2(@RequestParam("id") String id)
    {
        employeeService.deleteEmployee(Integer.parseInt(id));
        return "redirect:/employee/list-employees";
    }


    @RequestMapping(value = "/update/{firstname}/{lastname}/{phone}/{email}/{department}",
                    method = RequestMethod.GET,
                    params = {"id", "birthDate"})
    @ResponseBody
    public String updateEmployee(@RequestParam(value = "id", defaultValue = "0") String id,
                                 @PathVariable(value = "firstname") String firstname,
                                 @PathVariable(value = "lastname") String lastname,
                                 @PathVariable(value = "phone") String phone,
                                 @PathVariable(value = "email") String email,
                                 @PathVariable(value = "department") String department,
                                 @RequestParam("birthDate") String birth_date) throws ParseException {
        employeeService.updateEmployee(Integer.parseInt(id),
                new Employee(firstname, lastname, new SimpleDateFormat("yyyy-MM-dd").parse(birth_date), phone, email, department));
        return "update done";
    }

    @RequestMapping(value = "/update-param",
            method = RequestMethod.GET,
            params = {"id",
                    "firstname",
                    "lastname",
                    "phone",
                    "email",
                    "department",
                    "birthDate"})
    @ResponseBody
    public String updateEmployeeParam(@RequestParam(value = "id", defaultValue = "0") String id,
                                 @RequestParam(value = "firstname") String firstname,
                                 @RequestParam(value = "lastname") String lastname,
                                 @RequestParam(value = "phone") String phone,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "department") String department,
                                 @RequestParam("birthDate") String birth_date) throws ParseException {
        employeeService.updateEmployee(Integer.parseInt(id),
                new Employee(firstname, lastname, new SimpleDateFormat("yyyy-MM-dd").parse(birth_date), phone, email, department));
        return "update done";
    }


}
