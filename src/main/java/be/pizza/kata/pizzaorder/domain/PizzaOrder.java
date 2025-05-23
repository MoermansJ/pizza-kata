package be.pizza.kata.pizzaorder;

import be.pizza.kata.pizzaorder.controller.PizzaOrderCreateRequest;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

import java.util.Objects;

public class PizzaOrder {
    private final String pizza;
    private final String size;

    public PizzaOrder(PizzaOrderCreateRequest dto) {
        this.pizza = dto.getPizza();
        this.size = dto.getSize();
        this.validate();
    }

    private void validate() {
        StringBuilder message = new StringBuilder();
        String newLine = System.lineSeparator();

        if (pizza == null || pizza.isBlank()) {
            message.append("Pizza cannot be null or blank.").append(newLine);
        }
        if (size == null || size.isBlank()) {
            message.append("Size cannot be null or blank.").append(newLine);
        }

        if (!message.isEmpty()) {
            throw new PizzaOrderException("Invalid PizzaOrder: " + message);
        }

        return;
    }

    public String getPizza() {
        return pizza;
    }

    public String getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrder that)) return false;
        return Objects.equals(pizza, that.pizza) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza, size);
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
