package be.pizza.kata.pizzaorder.controller;

import java.util.Objects;

public class PizzaOrderCreateRequest {
    private String pizza;
    private String size;

    public PizzaOrderCreateRequest(String pizza, String size) {
        this.pizza = pizza;
        this.size = size;
    }

    public String getPizza() {
        return pizza;
    }

    public String getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrderCreateRequest that)) return false;
        return Objects.equals(pizza, that.pizza) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza, size);
    }

    @Override
    public String toString() {
        return "PizzaOrderCreateRequest{" +
                "pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
