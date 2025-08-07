package be.pizza.kata.pizzaorder.fixture;

import be.pizza.kata.pizzaorder.domain.model.Pizza;
import be.pizza.kata.pizzaorder.domain.model.PizzaSize;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;

import java.util.UUID;

public class PizzaOrderEntityFixture {
    public static PizzaOrderEntity unpersistedMediumMargherita() {
        return PizzaOrderEntity.builder()
                .pizza(Pizza.MARGHERITA)
                .size(PizzaSize.MEDIUM)
                .build();
    }

    public static PizzaOrderEntity stubPersistedMediumMargherita() {
        var id = "00000000-0000-0000-0000-000000000010";
        return PizzaOrderEntity.builder()
                .id(UUID.fromString(id))
                .pizza(Pizza.MARGHERITA)
                .size(PizzaSize.MEDIUM)
                .build();
    }
}
