package com.axon.order.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String productId;
    private int quantity;

    public CreateOrderCommand(String orderId, String productId, int quantity) {
        if (productId.equals("")) {
            throw new IllegalArgumentException("ProductId is Empty.");
        }
        this.orderId = orderId;
        this.productId = productId;
        if (quantity == 0) {
            throw new IllegalArgumentException("Quantity cannot be zero.");
        }
        this.quantity = quantity;
    }
}
