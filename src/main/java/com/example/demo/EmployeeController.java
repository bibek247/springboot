package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(value = "/entityEmployees", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<List<Employee>> getEmployeesEntity() {
        return new ResponseEntity<List<Employee>>(employeeslist(), HttpStatus.OK);
    }

    @GetMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE })
    public List<Employee> getEmployees() {
        return employeeslist();
    }

    @GetMapping(value = "/entityEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<Employee> getEmployeeEntity() {
        return new ResponseEntity<Employee>(new Employee("John", "Developer"), HttpStatus.OK);
    }

    @GetMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE })
    public Employee getEmployee() {
        return new Employee("John", "Developer");
    }
    
    @GetMapping(value = "/employeesjson", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Employee> getEmployeesjson() {
        return employeeslist();
    }

    private List<Employee> employeeslist() {
        List<Employee> employees = Arrays.asList(new Employee("John", "Developer"),
                new Employee("Michel", "Sr Developer"), new Employee("Harris", "Developer"),
                new Employee("Kamla", "Sr Developer"), new Employee("Jerome", "Manager"));

        return employees;
    }
	
}
