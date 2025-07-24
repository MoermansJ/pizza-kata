
package be.pizza.kata.pizzaorder.repository;

import be.pizza.kata.pizzaorder.domain.model.Pizza;
import be.pizza.kata.pizzaorder.domain.model.PizzaSize;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pizza_order")
public class PizzaOrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pizza", nullable = false)
    private Pizza pizza;
    @Column(name = "size", nullable = false)
    private PizzaSize size;

    public PizzaOrderEntity() {
    }

    public PizzaOrderEntity(Pizza pizza, PizzaSize size) {
        this.pizza = pizza;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PizzaOrderEntity{" +
                "id=" + id +
                ", pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrderEntity that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(pizza, that.pizza) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pizza, size);
    }

}
