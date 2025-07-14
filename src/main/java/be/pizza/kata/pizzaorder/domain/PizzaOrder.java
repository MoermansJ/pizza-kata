package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.commons.notification.Notification;
import be.pizza.kata.commons.notification.Validate;
import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveRequest;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;

import java.util.Objects;

public class PizzaOrder implements Validate {
    private final Pizza pizza;
    private final PizzaSize size;

    public PizzaOrder(PizzaOrderSaveRequest dto) {
        if (dto == null) {
            throw new PizzaOrderException("PizzaOrderSaveRequest cannot be null");
        }

        this.pizza = Pizza.fromString(dto.getPizza());
        this.size = PizzaSize.fromString(dto.getSize());
        this.validate();
    }

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaSize getSize() {
        return size;
    }

    @Override
    public Notification validate() {
        var notification = new Notification();

        if (pizza == null) {
            notification.addError("Pizza cannot be " + pizza);
        }
        if (size == null) {
            notification.addError("PizzaSize cannot be " + size);
        }

        return notification;
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
                ", pizzaSize='" + size + '\'' +
                '}';
    }
}
