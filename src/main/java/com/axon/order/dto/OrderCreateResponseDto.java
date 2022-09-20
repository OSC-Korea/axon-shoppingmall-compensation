package com.axon.order.dto;

import com.axon.order.command.CreateOrderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreateResponseDto {
    private OrderCreateRequestDto orderCreateRequestDto;
}
