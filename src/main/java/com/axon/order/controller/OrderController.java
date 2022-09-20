package com.axon.order.controller;

import com.axon.order.command.CreateOrderCommand;
import com.axon.order.dto.OrderCreateRequestDto;
import com.axon.order.dto.OrderCreateResponseDto;
import com.axon.order.entity.OrderEntity;
import com.axon.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/")
    public ResponseEntity<List<OrderEntity>> getOrders() throws ExecutionException, InterruptedException {

        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping(value = "/")
    public ResponseEntity<OrderCreateResponseDto> createOrder(@RequestBody OrderCreateRequestDto dto) {

        Object createOrderCommand = orderService.createOrder(dto.getProductId(), dto.getQuantity());
        OrderCreateResponseDto orderCreateResponseDto = new OrderCreateResponseDto(dto);
        return ResponseEntity.ok(orderCreateResponseDto);
    }
}
