package com.axon.order.entity;

import com.axon.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderEntity {
    @Id
    private String id;
    private String productId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void cancelOrder() {
        this.orderStatus = OrderStatus.CANCELED;
    }
}
