package be.pizza.kata.pizzaorder.adapter.controller;

import org.springframework.lang.NonNull;

public record PizzaOrderRequest(@NonNull String pizza, @NonNull String size)  {
}
