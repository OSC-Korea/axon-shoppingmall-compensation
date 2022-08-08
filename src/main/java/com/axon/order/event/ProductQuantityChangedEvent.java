package com.axon.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductQuantityChangedEvent {
    private String productId;
    private int quantity;
}
