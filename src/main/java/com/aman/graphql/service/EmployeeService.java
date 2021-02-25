package com.aman.graphql.service;

import com.aman.graphql.entity.Address;
import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Name;
import com.aman.graphql.entity.Position;
import com.aman.graphql.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee){
        return createEmployee(
                employee.getName(),
                employee.getAddress(),
                employee.getPosition(),
                new ArrayList<>()
                //employee.getWorkers()
        );
    }

    public Employee createEmployee(Name name, Address address, Position position, List<Employee> workers){

        log.info("Creating an Employee ...");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setPosition(position);
        //employee.setWorkers(workers);
        return this.employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(final int cont){

        log.info("Getting an Employee for count : {}", cont);
        return this.employeeRepository.findAll(PageRequest.of(0, cont)).toList();
    }

    public Optional<Employee> getEmployeeById(final int id){

        log.info("Getting employee for id : {}", id);
        return  this.employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByPosition(final Position position){
        log.info("Getting employees for position : {}", position.toString());
        return this.employeeRepository.findByPosition(position);
    }

}
