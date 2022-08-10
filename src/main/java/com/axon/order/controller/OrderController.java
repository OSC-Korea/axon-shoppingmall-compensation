package com.axon.order.controller;

import com.axon.order.dto.OrderCreateDto;
import com.axon.order.entity.OrderEntity;
import com.axon.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/")
    public ResponseEntity<List<OrderEntity>> getOrders() throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> createOrder(@RequestBody OrderCreateDto dto) {

        orderService.createOrder(dto.getProductId(), dto.getQuantity());
        return ResponseEntity.ok("POST");
    }
}
