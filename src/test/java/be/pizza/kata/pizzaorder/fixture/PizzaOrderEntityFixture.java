package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;

import java.util.UUID;

public class PizzaOrderEntityFixture {
    private static final String PIZZA = "Margherita";
    private static final String SIZE = "Medium";
    private static final UUID ID = UUID.fromString("00000000-0000-0000-0000-000000000010");

    public static PizzaOrderEntity unsavedMediumMargherita() {
        var entity = new PizzaOrderEntity();
        entity.setPizza(PIZZA);
        entity.setSize(SIZE);
        return entity;
    }
}
