
package be.pizza.kata.pizzaorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrderEntity, UUID> {
}
