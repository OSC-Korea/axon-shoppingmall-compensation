package com.axon.order.query.handler;

import com.axon.order.entity.OrderEntity;
import com.axon.order.query.GetOrdersQuery;
import com.axon.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderQueryHandler {

    private final OrderRepository orderRepository;

    @QueryHandler
    protected List<OrderEntity> orderFindAll(GetOrdersQuery query) {
        log.info("---order query---");
        return orderRepository.findAll();
    }
}
