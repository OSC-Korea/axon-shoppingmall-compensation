package com.axon.order.query.handler;

import com.axon.order.entity.ProductEntity;
import com.axon.order.query.GetProductsQuery;
import com.axon.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    protected List<ProductEntity> on(GetProductsQuery query) {
        return productRepository.findAll();
    }

}
