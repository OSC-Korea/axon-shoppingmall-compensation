package com.axon.order.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@Getter
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String productId;
    private int quantity;

}
