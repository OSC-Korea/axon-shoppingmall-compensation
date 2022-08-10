package com.axon.order.aggregate;

import com.axon.order.command.ChangeQuantityCommand;
import com.axon.order.command.CreateProductCommand;
import com.axon.order.event.ProductCreatedEvent;
import com.axon.order.event.ProductQuantityChangedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private int quantiy;


    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        apply(new ProductCreatedEvent(command.getId(), command.getName(), command.getQuantity(), command.getPrice()));
    }

    @EventSourcingHandler
    public void createProduct(ProductCreatedEvent event) {
        this.id = event.getProductId();
        this.quantiy = event.getQuantity();
    }

    @CommandHandler
    public void changeQuantity(ChangeQuantityCommand command) {
        if(this.quantiy < command.getQuantity()) throw new IllegalArgumentException("tfy ");
        apply(new ProductQuantityChangedEvent(command.getProductId(), this.quantiy - command.getQuantity()));
    }

    @EventSourcingHandler
    public void changeProductQuantity(ProductQuantityChangedEvent event) {
        this.quantiy = event.getQuantity();
    }

}
