package com.aman.graphql.service;

import com.aman.graphql.dto.EmployeeFilter;
import com.aman.graphql.entity.Address;
import com.aman.graphql.entity.Employee;
import com.aman.graphql.entity.Name;
import com.aman.graphql.entity.Position;
import com.aman.graphql.exceptions.EmployeeNameAlreadyExistException;
import com.aman.graphql.exceptions.EmployeeNotFoundException;
import com.aman.graphql.publisher.EmployeePublisher;
import com.aman.graphql.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final String EMPLOYEE_NAME_ERROR_MSG = "Employee with the name already exist, Pls try with some different name";
    private static final String EMPLOYEE_NOT_FOUND_ERROR_MSG = "Employee not found for id %s";
    private final EmployeePublisher employeePublisher;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeePublisher employeePublisher) {
        this.employeeRepository = employeeRepository;
        this.employeePublisher = employeePublisher;
    }

    @Transactional
    public Employee createEmployee(Employee employee){
        return createEmployee(
                employee.getName(),
                employee.getAddress(),
                employee.getPosition()
        );
    }


    @Transactional
    public Employee createEmployee(Name name, Address address, Position position){
        log.info("Creating an Employee ...");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setPosition(position);
        if(isEmployeeNameAlreadyExist(name)){
            throw new EmployeeNameAlreadyExistException(EMPLOYEE_NAME_ERROR_MSG);
        }
        Employee savedEmployee = this.employeeRepository.save(employee);
        log.info("publishing event for save_employee : {}", savedEmployee);
        employeePublisher.publish(savedEmployee);
        return savedEmployee;
    }

    private Boolean isEmployeeNameAlreadyExist(final Name name){
        log.info("checking if employee is already existed with name : {}", name);
        return getEmployeeByName(name).isPresent();
    }

    @Transactional
    public List<Employee> getAllEmployees(final int cont){
        log.info("Getting an Employee for count : {}", cont);
        return this.employeeRepository.findAll(PageRequest.of(0, cont)).toList();
    }

    @Transactional
    public Employee getEmployeeById(final int id) throws EmployeeNotFoundException{
        log.info("Getting employee for id : {}", id);
        return  this.employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format(EMPLOYEE_NOT_FOUND_ERROR_MSG, id)));
    }

    @Transactional
    public List<Employee> getEmployeeByPosition(final Position position){
        log.info("Getting employees for position : {}", position.toString());
        return this.employeeRepository.findByPosition(position);
    }

    @Transactional
    public Optional<Employee> getEmployeeByName(final Name name){
        log.info("Getting employee for Name : {}", name);
        return this.employeeRepository.findByName(name);
    }

    @Transactional
    public List<Employee> filter(final EmployeeFilter employeeFilter){
        log.info("filter : {}", employeeFilter);
        List<Predicate> predicateList = new ArrayList<>();

        // setting up Builders
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        if(StringUtils.isNotEmpty(employeeFilter.getCountry())){
            predicateList.add(criteriaBuilder.equal(root.get("address").<String> get("country"), employeeFilter.getCountry()));
        }
        if(StringUtils.isNotEmpty(employeeFilter.getFirstName())){
            predicateList.add(criteriaBuilder.equal(root.get("name").<String> get("firstName"), employeeFilter.getFirstName()));
        }
        if(employeeFilter.getPosition() != null){
            predicateList.add(criteriaBuilder.equal(root.get("position"), employeeFilter.getPosition()));
        }
        if(employeeFilter.getId() != 0){
            predicateList.add(criteriaBuilder.equal(root.get("id"), employeeFilter.getId()));
        }

        Predicate[] predicateArray = new Predicate[predicateList.size()];
        predicateList.toArray(predicateArray);

        CriteriaQuery<Employee> executeQuery = criteriaQuery.select(root).where(predicateArray).orderBy(criteriaBuilder.asc(root.get("name").<String> get("firstName")));
        List<Employee> employees = entityManager.createQuery(executeQuery).getResultList();
        return employees;
    }
}
