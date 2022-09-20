package com.axon.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreateRequestDto {

    private String productId;
    private int quantity;

}
