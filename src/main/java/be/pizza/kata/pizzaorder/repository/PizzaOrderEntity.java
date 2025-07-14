
package be.pizza.kata.pizzaorder.repository;

import be.pizza.kata.pizzaorder.domain.PizzaOrder;
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
    private String pizza;
    @Column(name = "size", nullable = false)
    private String size;

    public PizzaOrderEntity() {
    }

    public PizzaOrderEntity(String pizza, String size) {
        this.pizza = pizza;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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
