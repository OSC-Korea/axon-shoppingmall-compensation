package com.axon.order.service;

import com.axon.order.command.CreateOrderCommand;
import com.axon.order.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.StartSaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CommandGateway commandGateway;

    public void createOrder(String productId, int quantity) {
        // product과 관련 있는 부분
        // command를 발행
        commandGateway.sendAndWait(new CreateOrderCommand(UUID.randomUUID().toString(), productId, quantity));
    }

}
