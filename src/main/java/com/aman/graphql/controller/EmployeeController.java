package com.aman.graphql.controller;

import com.aman.graphql.dto.EmployeeFilter;
import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Name;
import com.aman.graphql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("name")
    public ResponseEntity getEmployeeByName(@RequestBody Name name){
        return ResponseEntity.ok(employeeService.getEmployeeByName(name));
    }

    @GetMapping("hello")
    public ResponseEntity hello(){
        log.info("Hello Aman !");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("filter")
    public ResponseEntity filterEmployee(@RequestBody EmployeeFilter employeeFilter){
        return ResponseEntity.ok(employeeService.filter(employeeFilter));
    }

}
