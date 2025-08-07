package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.adapter.repository.PizzaOrderRepositoryFacade;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderRepository;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class OrderPizzaUsecaseTestConfig {

    @Bean
    public OrderPizzaUsecase orderPizzaUseCase(PizzaOrderRepository pizzaOrderRepository) {
        return new OrderPizzaUsecase(pizzaOrderRepository, "20 minutes");
    }

    @Bean
    public PizzaOrderRepository pizzaOrderRepository() {
        return Mockito.mock(PizzaOrderRepositoryFacade.class);
    }
}
