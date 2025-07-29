package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.controller.model.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.controller.model.PizzaOrderResponse;
import be.pizza.kata.pizzaorder.domain.model.PizzaOrderFactory;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

    @Value("${order.pizza.estimated-time}")
    private static String ESTIMATED_TIME;
    private final PizzaOrderRepository repository;

    public PizzaOrderService(PizzaOrderRepository repository) {
        this.repository = repository;
    }

    public PizzaOrderResponse save(PizzaOrderRequest request) {
        var order = PizzaOrderFactory.createFrom(request);
        var unsaved = new PizzaOrderEntity(order.pizza(), order.size());
        var saved = repository.save(unsaved);
        var savedId = saved.getId().toString();

        return new PizzaOrderResponse(savedId, ESTIMATED_TIME);
    }
}
