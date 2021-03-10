package com.aman.graphql.query;

import com.aman.graphql.entity.Order;
import com.aman.graphql.entity.OrderItem;
import com.aman.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class OrderItemResolver implements GraphQLResolver<Order> {

    @Autowired
    private OrderService orderService;

    public List<OrderItem> items(Order order){
        log.info("getting OrderItem for id : {}", order.getId());
        Order newOrder = orderService.getById(order.getId());
        newOrder.getItems().stream().forEach(i -> log.info("Item : {}",i));
        return orderService.getById(order.getId()).getItems().stream().collect(Collectors.toList());
    }

}
