package com.aman.graphql.query;

import com.aman.graphql.dto.EmployeeFilter;
import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Position;
import com.aman.graphql.exceptions.EmployeeNotFoundException;
import com.aman.graphql.service.EmployeeService;
import graphql.kickstart.tools.GraphQLQueryResolver;
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

    public Employee getEmployee(final int id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    public List<Employee> getEmployeeByPosition(final Position position){
        return employeeService.getEmployeeByPosition(position);
    }

    public List<Employee> filterEmployee(EmployeeFilter filter){
        return employeeService.filter(filter);
    }
}
