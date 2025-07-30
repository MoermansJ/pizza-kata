package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class OrderPizzaUseCaseTestConfig {

    @Bean
    public OrderPizzaUseCase orderPizzaUseCase(PizzaOrderRepository pizzaOrderRepository) {
        return new OrderPizzaUseCase(pizzaOrderRepository, "20 minutes");
    }

    @Bean
    public PizzaOrderRepository pizzaOrderRepository() {
        return Mockito.mock(PizzaOrderRepository.class);
    }
}
