package be.pizza.kata.pizzaorder.repository;

import be.pizza.kata.commons.testcontainers.PostgreSQLTestContainer;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderEntityFixture;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@Disabled("Disabled docker to save battery")
class PizzaOrderRepositoryTest {

    @DynamicPropertySource
    static void containerProperties(DynamicPropertyRegistry registry) {
        var container = PostgreSQLTestContainer.getInstance();
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
    }

    @Autowired
    private PizzaOrderRepository repository;

    @Test
    void givenValidEntity_whenSave_thenEntityIsPersisted() {
        var unsaved = PizzaOrderEntityFixture.unpersistedMediumMargherita();
        var saved = repository.save(unsaved);

        assertNotNull(saved);
        assertEquals(unsaved.getId(), saved.getId());
        assertEquals(unsaved.getPizza(), saved.getPizza());
        assertEquals(unsaved.getSize(), saved.getSize());
    }
}
