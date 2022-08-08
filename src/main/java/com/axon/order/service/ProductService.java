package com.axon.order.service;

import com.axon.order.command.CreateOrderCommand;
import com.axon.order.command.CreateProductCommand;
import com.axon.order.entity.ProductEntity;
import com.axon.order.query.GetProductsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public ProductService(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    public String createProduct(String name, BigDecimal price, Integer quantity) {
        // command생성
        CreateProductCommand createProductCommand = new CreateProductCommand(
                UUID.randomUUID().toString(), name, price, quantity
        );

        // 생성한 command전송(비동기)
        String returnValue = commandGateway.sendAndWait(createProductCommand);
        System.out.printf("returnValue: %s \n", returnValue);
        return returnValue;
    }

    public List<ProductEntity> getProducts() throws ExecutionException, InterruptedException {
        return queryGateway.query(new GetProductsQuery(),
                ResponseTypes.multipleInstancesOf(ProductEntity.class)).get();
    }

}
