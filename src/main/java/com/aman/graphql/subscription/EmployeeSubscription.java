package com.aman.graphql.subscription;

import com.aman.graphql.entity.Employee;
import com.aman.graphql.publisher.EmployeePublisher;
import com.aman.graphql.repository.EmployeeRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EmployeeSubscription implements GraphQLSubscriptionResolver {

    private EmployeeRepository employeeRepository;
    private EmployeePublisher employeePublisher;

    @Autowired
    public EmployeeSubscription(EmployeeRepository employeeRepository, EmployeePublisher employeePublisher) {
        this.employeeRepository = employeeRepository;
        this.employeePublisher = employeePublisher;
    }

    /**
     * Here we are raising event only when created Employee
     * @return
     */
    public Publisher<Employee> employees(){
        return employeePublisher.getPublisher();
    }

    /**
     * Here we can declare subscription to push event after some delay
     */
/*
    public Publisher<List<Employee>> employees(){
        return new Publisher<List<Employee>>() {
            @Override
            public void subscribe(Subscriber<? super List<Employee>> subscriber) {
                Executors.newScheduledThreadPool(1)
                        .scheduleWithFixedDelay(() -> {
                            List<Employee> employees = employeeRepository.findAll();
                            subscriber.onNext(employees);
                        }, 0, 2, TimeUnit.SECONDS);
            }
        };
    }*/

    /**
     *This is a lambda implementation of above code
     * @return
     */
    /*public Publisher<List<Employee>> employees() {
        return subscriber -> Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(() -> {
                    List<Employee> employees = employeeRepository.findAll();
                    log.info("Employee list : {}", employees);
                    subscriber.onNext(employees);
                }, 0, 3, TimeUnit.SECONDS);
    }*/

}
