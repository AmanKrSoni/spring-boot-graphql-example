package com.aman.graphql.repository;

import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Name;
import com.aman.graphql.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByPosition(Position position);

    Optional<Employee> findByName(Name name);
}
