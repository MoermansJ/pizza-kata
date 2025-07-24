package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.domain.model.Pizza;
import be.pizza.kata.pizzaorder.domain.model.PizzaSize;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;

public class PizzaOrderEntityFixture {

    public static PizzaOrderEntity unsavedMediumMargherita() {
        return new PizzaOrderEntity(Pizza.MARGHERITA, PizzaSize.MEDIUM);
    }
}
