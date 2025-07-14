package be.pizza.kata.pizzaorder.controller;

import be.pizza.kata.commons.notification.Notification;
import be.pizza.kata.commons.notification.Validate;
import be.pizza.kata.pizzaorder.domain.Pizza;
import be.pizza.kata.pizzaorder.domain.PizzaSize;

import java.util.Objects;

public class PizzaOrderSaveRequest implements Validate {
    private String pizza;
    private String size;

    public PizzaOrderSaveRequest(String pizza, String size) {
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
    public Notification validate() {
        var notification = new Notification();

        if (pizza == null || pizza.isBlank() || !Pizza.isValid(pizza)) {
            notification.addError("Pizza cannot be " + pizza);
        }
        if (size == null || size.isBlank() || !PizzaSize.isValid(size)) {
            notification.addError("Size cannot be " + size);
        }

        return notification;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrderSaveRequest that)) return false;
        return Objects.equals(pizza, that.pizza) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizza, size);
    }

    @Override
    public String toString() {
        return "PizzaOrderSaveRequest{" +
                "pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
