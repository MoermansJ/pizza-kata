package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.adapter.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.adapter.PizzaOrderResponse;
import be.pizza.kata.pizzaorder.domain.PizzaOrderFactory;
import be.pizza.kata.pizzaorder.repository.model.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderPizzaUseCase {

    private final String estimatedTime;
    private final PizzaOrderRepository repository;

    public OrderPizzaUseCase(PizzaOrderRepository repository, @Value("${order.pizza.estimated-time}") String estimatedTime) {
        this.repository = repository;
        this.estimatedTime = estimatedTime;
    }

    public PizzaOrderResponse execute(PizzaOrderRequest request) {
        var order = PizzaOrderFactory.createFrom(request);
        var unsaved = new PizzaOrderEntity(order.pizza(), order.size());
        var saved = repository.save(unsaved);
        var savedId = saved.getId().toString();

        return new PizzaOrderResponse(savedId, estimatedTime);
    }
}
