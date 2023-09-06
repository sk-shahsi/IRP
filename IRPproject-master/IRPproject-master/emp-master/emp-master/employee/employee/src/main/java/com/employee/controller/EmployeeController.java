package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.pojo.EmployeePojo;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("*")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeServices;

    @PostMapping("/employee/save")
    public ResponseEntity<?> saveEmployee( @RequestBody EmployeePojo employee) {
        Employee entity = null;
        entity = employeeServices.createEmployee(employee);

        return new ResponseEntity<>("create with empId: " + entity.getEmpId(), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Employee> getAll() {

        return employeeServices.getAllEmployee();
    }

    @GetMapping("/getAll:salary-grater-5000")
    public List<Employee> getAllEmployeeGrater() {
        return employeeServices.employeeSalaryGrater();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable("employeeId") int empId) {
        Employee employee=null;
         employee=employeeServices.getEmployeeById(empId);
         return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete")
    public ResponseEntity<?> deletEmp(@PathVariable("id") int empId) {
        employeeServices.deleteEmployee(empId);
        return new ResponseEntity<>("deleted id "+empId,HttpStatus.OK);
    }



}
