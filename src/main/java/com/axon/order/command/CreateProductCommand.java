package com.axon.order.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final Integer quantity;

}
