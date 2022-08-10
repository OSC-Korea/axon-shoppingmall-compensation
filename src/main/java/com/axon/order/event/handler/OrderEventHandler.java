package com.axon.order.event.handler;

import com.axon.order.entity.OrderEntity;
import com.axon.order.enums.OrderStatus;
import com.axon.order.event.OrderCanceledEvent;
import com.axon.order.event.OrderCreatedEvent;
import com.axon.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventHandler {

    private final OrderRepository orderRepository;

    public OrderEventHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @EventHandler
    public void saveOrder(OrderCreatedEvent event) {
        log.info("[saveOrder]");
        orderRepository.save(new OrderEntity(event.getOrderId(), event.getProductId(), OrderStatus.CREATED));
    }

    @EventHandler
    public void cancelOrder(OrderCanceledEvent event) {
        log.info("[OrderCanceledEvent]");
        OrderEntity order = orderRepository.findById(event.getOrderId()).get();
        order.cancelOrder();
        orderRepository.save(order);
    }

}
