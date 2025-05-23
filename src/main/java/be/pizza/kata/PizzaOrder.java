
package be.pizza.kata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pizza", nullable = false)
    private String pizza;
    @Column(name = "size", nullable = false)
    private String size;

    protected PizzaOrder() {
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
        return "PizzaOrder{" +
                "id=" + id +
                ", pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PizzaOrder that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(pizza, that.pizza) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pizza, size);
    }

}
