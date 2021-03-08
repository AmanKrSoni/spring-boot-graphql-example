package com.aman.graphql.mutation;

import com.aman.graphql.entity.Address;
import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Name;
import com.aman.graphql.entity.Position;
import com.aman.graphql.service.EmployeeService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeMutation implements GraphQLMutationResolver {
    @Autowired
    private EmployeeService employeeService;

    public Employee createEmployee(Employee employee){
        return employeeService.createEmployee(
                employee.getName(),
                employee.getAddress(),
                employee.getPosition()
        );
    }

    public Employee createEmployee(Name name, Address address, Position position){
        return employeeService.createEmployee(name, address, position);
    }

}
