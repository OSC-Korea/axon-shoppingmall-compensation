package com.axon.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCanceledEvent {
    private String orderId;
}
