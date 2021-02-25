package com.aman.graphql.repository;

import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByPosition(Position position);
}
