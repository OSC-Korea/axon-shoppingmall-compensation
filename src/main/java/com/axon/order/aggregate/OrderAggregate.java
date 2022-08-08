package com.axon.order.aggregate;

import com.axon.order.command.CreateOrderCommand;
import com.axon.order.event.OrderCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class OrderAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(command.getOrderId(), command.getProductId(), command.getQuantity());
        apply(orderCreatedEvent);

    }

    @EventSourcingHandler
    public void createOrder(OrderCreatedEvent event) {
        this.id = event.getOrderId();
    }
}
