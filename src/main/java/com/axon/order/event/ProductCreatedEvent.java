package com.axon.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private int quantity;
    private BigDecimal price;
}
