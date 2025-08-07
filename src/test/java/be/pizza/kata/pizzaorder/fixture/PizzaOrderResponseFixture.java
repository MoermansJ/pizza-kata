package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.usecase.PizzaOrderResponse;

public class PizzaOrderResponseFixture {

    public static PizzaOrderResponse twentyMinutesEstimatedTimeAndValidOrderId() {
        var entity = PizzaOrderEntityFixture.stubPersistedMediumMargherita();
        return new PizzaOrderResponse(entity, "20 minutes");
    }
}
