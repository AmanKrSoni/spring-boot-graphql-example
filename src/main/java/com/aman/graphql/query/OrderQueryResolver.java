package com.aman.graphql.query;

import com.aman.graphql.entity.Order;
import com.aman.graphql.service.OrderService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private OrderService orderService;

    public Order getOrder(final long id){
        return orderService.getById(id);
    }

    public List<Order> getAllOrders(final int count){
        return orderService.getAllOrder().stream().limit(count).collect(Collectors.toList());
    }
}
