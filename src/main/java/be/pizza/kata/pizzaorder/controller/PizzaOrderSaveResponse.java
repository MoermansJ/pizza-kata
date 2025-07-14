package be.pizza.kata.pizzaorder.controller;

import java.util.Objects;
import java.util.UUID;

public class PizzaOrderSaveResponse {
    private final String orderId;
    private final String estimatedTime;

    public PizzaOrderSaveResponse(UUID orderId, String estimatedTime) {
        this.orderId = orderId.toString();
        this.estimatedTime = estimatedTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrderSaveResponse that)) return false;
        return Objects.equals(orderId, that.orderId) && Objects.equals(estimatedTime, that.estimatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, estimatedTime);
    }

    @Override
    public String toString() {
        return "PizzaOrderSaveResponse{" +
                "orderId='" + orderId + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                '}';
    }
}
