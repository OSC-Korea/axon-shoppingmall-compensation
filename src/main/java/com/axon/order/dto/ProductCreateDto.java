package com.axon.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateDto {
    private String name;
    private int quantity;
    private int price;
}

