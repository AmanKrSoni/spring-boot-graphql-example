package com.aman.graphql.subscription;

import com.aman.graphql.entity.Employee;
import com.aman.graphql.repository.EmployeeRepository;
//import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EmployeeSubscription implements GraphQLSubscriptionResolver {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeSubscription(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Publisher<List<Employee>> employees() {
        return subscriber -> Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(() -> {
                    List<Employee> employees = employeeRepository.findAll();
                    log.info("Employee list : {}", employees);
                    subscriber.onNext(employees);
                }, 0, 3, TimeUnit.SECONDS);
    }

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
}
