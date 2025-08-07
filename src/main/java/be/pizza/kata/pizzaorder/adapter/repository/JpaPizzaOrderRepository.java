package be.pizza.kata.pizzaorder.adapter.repository;

import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPizzaOrderRepository extends JpaRepository<PizzaOrderEntity, Long> {
}
