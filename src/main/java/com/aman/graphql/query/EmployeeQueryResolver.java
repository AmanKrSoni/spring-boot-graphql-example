package com.aman.graphql.query;

import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Position;
import com.aman.graphql.service.EmployeeService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getAllEmployees(final int count){
        return employeeService.getAllEmployees(count);
    }

    public Employee getEmployee(final int id){
        return employeeService.getEmployeeById(id).orElse(new Employee());
    }

    public List<Employee> getEmployeeByPosition(final Position position){
        return employeeService.getEmployeeByPosition(position);
    }
}