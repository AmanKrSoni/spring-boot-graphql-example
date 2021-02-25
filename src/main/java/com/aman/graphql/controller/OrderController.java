package com.aman.graphql.controller;

import com.aman.graphql.entity.Order;
import com.aman.graphql.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity save(@RequestBody Order order){
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
