package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class PizzaOrderServiceTestConfig {

    @Bean
    public PizzaOrderService pizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        return new PizzaOrderService(pizzaOrderRepository);
    }

    @Bean
    public PizzaOrderRepository pizzaOrderRepository() {
        return Mockito.mock(PizzaOrderRepository.class);
    }
}
