package com.axon.order.event.handler;

import com.axon.order.entity.ProductEntity;
import com.axon.order.event.ProductCreatedEvent;
import com.axon.order.event.ProductQuantityChangedEvent;
import com.axon.order.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    protected void on(ProductCreatedEvent productCreatedEvent) {

        log.info("[ProductCreatedEvent] productCreatedEvent");
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productCreatedEvent.getProductId());
        productEntity.setName(productCreatedEvent.getName());
        productEntity.setQuentity(productCreatedEvent.getQuantity());
        productEntity.setPrice(productCreatedEvent.getPrice());

        productRepository.save(productEntity);

    }

    @EventHandler
    protected void on(ProductQuantityChangedEvent productQuantityChangedEvent) {
        ProductEntity productEntity = productRepository.findById(productQuantityChangedEvent.getProductId()).get();
        log.info("[{}] quantity:{}", productEntity.getName(), productEntity.getQuentity());
        productEntity.setQuentity(productQuantityChangedEvent.getQuantity());
        productRepository.save(productEntity);
    }

}
