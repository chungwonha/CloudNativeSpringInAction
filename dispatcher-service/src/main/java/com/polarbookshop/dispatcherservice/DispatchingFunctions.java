package com.polarbookshop.dispatcherservice;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class DispatchingFunctions {
    @Bean
    public Function<OrderAcceptedMessage, Long> pack() {
        return orderAcceptedMessage -> {
            log.info("The order with id " + orderAcceptedMessage.getOrderId() + " is packed.");
            return orderAcceptedMessage.getOrderId();
        };
    }

    @Bean
    public Function<Flux<Long>, Flux<OrderDispatchedMessage>> label() {
        return orderFlux -> orderFlux.map(orderId -> {
            log.info("The order with id " + orderId + " is labeled.");
            return new OrderDispatchedMessage(orderId);
        });
    }

    public Function<Long, OrderDispatchedMessage> test(){
        return a->{
            log.info(a.toString());
            return new OrderDispatchedMessage(Long.decode("999"));
        };
    }
}