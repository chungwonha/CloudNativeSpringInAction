package com.polarbookshop.dispatcherservice;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderAcceptedMessage {
    Long orderId;
}