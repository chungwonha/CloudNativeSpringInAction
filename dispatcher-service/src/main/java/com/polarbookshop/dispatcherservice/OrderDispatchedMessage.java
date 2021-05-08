package com.polarbookshop.dispatcherservice;

import lombok.*;


public class OrderDispatchedMessage {

    Long orderId;

    public OrderDispatchedMessage(Long orderId) {
        this.orderId = orderId;
    }

    public OrderDispatchedMessage() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}