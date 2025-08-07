package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;

import java.util.Objects;
import java.util.UUID;

public class PizzaOrderResponse {

    private final UUID orderId;
    private final String estimatedTime;

    public PizzaOrderResponse(PizzaOrderEntity entity, String estimatedTime) {
        this.orderId = entity.getId();
        this.estimatedTime = estimatedTime;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrderResponse that)) return false;
        return Objects.equals(orderId, that.orderId) && Objects.equals(estimatedTime, that.estimatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, estimatedTime);
    }

    @Override
    public String toString() {
        return "PizzaOrderResponse{" +
                "orderId=" + orderId +
                ", estimatedTime='" + estimatedTime + '\'' +
                '}';
    }
}
