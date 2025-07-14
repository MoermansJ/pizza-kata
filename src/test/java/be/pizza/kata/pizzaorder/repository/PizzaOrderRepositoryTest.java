package be.pizza.kata.pizzaorder.repository;

import be.pizza.kata.pizzaorder.fixture.PizzaOrderEntityFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PizzaOrderRepositoryTest {

    @Autowired
    private PizzaOrderRepository repository;

    @Test
    void givenValidEntity_whenSave_thenEntityIsPersisted() {
        var unsaved = PizzaOrderEntityFixture.unsavedMediumMargherita();
        var saved = repository.save(unsaved);

        assertNotNull(saved);
        assertEquals(unsaved.getId(), saved.getId());
        assertEquals(unsaved.getPizza(), saved.getPizza());
        assertEquals(unsaved.getSize(), saved.getSize());
    }
}
