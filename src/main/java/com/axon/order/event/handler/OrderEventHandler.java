package com.axon.order.event.handler;

import com.axon.order.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventHandler {

    @EventHandler
    public void saveOrder(OrderCreatedEvent event) {
        log.info("[saveOrder]");

    }

}
