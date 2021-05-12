package com.polarbookshop.dispatcherservice;

import lombok.*;


@Data @AllArgsConstructor @NoArgsConstructor
public class OrderDispatchedMessage {
    Long orderId;
}