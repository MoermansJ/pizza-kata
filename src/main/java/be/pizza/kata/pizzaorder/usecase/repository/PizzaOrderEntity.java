
package be.pizza.kata.pizzaorder.usecase.repository;

import be.pizza.kata.pizzaorder.domain.Pizza;
import be.pizza.kata.pizzaorder.domain.PizzaOrder;
import be.pizza.kata.pizzaorder.domain.PizzaSize;
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

    protected PizzaOrderEntity() {
    }

    public PizzaOrderEntity(PizzaOrder order) {
        this.pizza = order.getPizza();
        this.size = order.getSize();
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

    public static PizzaOrderEntity.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private Pizza pizza;
        private PizzaSize size;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder pizza(Pizza pizza) {
            this.pizza = pizza;
            return this;
        }

        public Builder size(PizzaSize size) {
            this.size = size;
            return this;
        }

        public PizzaOrderEntity build() {
            PizzaOrderEntity entity = new PizzaOrderEntity();
            entity.setId(id);
            entity.setPizza(pizza);
            entity.setSize(size);
            return entity;
        }
    }

}
