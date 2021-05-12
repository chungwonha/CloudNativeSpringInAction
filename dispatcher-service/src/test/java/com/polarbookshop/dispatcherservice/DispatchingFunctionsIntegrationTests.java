package com.polarbookshop.dispatcherservice;

import java.util.function.Function;

//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

@FunctionalSpringBootTest
class DispatchingFunctionsIntegrationTests {

    @Autowired
    private FunctionCatalog catalog;

    private Logger log= LoggerFactory.getLogger(DispatchingFunctionsIntegrationTests.class);

//    @Test
    void packAndLabelOrder() {
        Function<OrderAcceptedMessage, Flux<OrderDispatchedMessage>> packAndLabel =
                catalog.lookup(Function.class, "pack|label");
        long orderId = 121;

//        StepVerifier
//                .create(packAndLabel.apply(new OrderAcceptedMessage(orderId)))
//                .expectNextMatches(dispatchedOrder -> dispatchedOrder.orderId.equals(orderId))
//                .verifyComplete();

        StepVerifier
                .create(packAndLabel.apply(new OrderAcceptedMessage(orderId)))
//                .expectNext(new OrderDispatchedMessage(orderId))
//                .expectNextMatches(dispatchedOrder ->{
//                                log.info(Long.toString(dispatchedOrder.getOrderId()));
//                                return true;
                //.equals(new OrderDispatchedMessage(orderId))
//                                            })
                .verifyComplete();
    }

    @Test
    void test123(){

        String s1 = new String("123");
        String s2 = new String("234");

        if(s1.equals(s2)){
            log.info("s1 and s2 are equal");
        }else{
            log.info("s1 and s2 are NOT equal");
        }

    }
}