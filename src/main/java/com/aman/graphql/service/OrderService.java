package com.aman.graphql.service;

import com.aman.graphql.entity.Order;
import com.aman.graphql.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(final Order order){
        log.info("Saving order ...");
        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> getAllOrder(){
        log.info("Getting all Orders  ...");
        return orderRepository.findAll();
    }

    @Transactional
    public Order getById(final Long id){
        log.info("Getting Order for id : {}", id);
        return orderRepository.getOne(id);
    }

}
