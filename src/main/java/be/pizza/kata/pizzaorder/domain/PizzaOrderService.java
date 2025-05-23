package be.pizza.kata.pizzaorder;

import be.pizza.kata.pizzaorder.controller.PizzaOrderCreateRequest;
import be.pizza.kata.pizzaorder.controller.PizzaOrderCreateResponse;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

    private final String ESTIMATED_TIME = "20 minutes";

    private final PizzaOrderRepository repository;

    public PizzaOrderService(PizzaOrderRepository repository) {
        this.repository = repository;
    }

    public PizzaOrderCreateResponse create(PizzaOrderCreateRequest dto) {
        var domain = new PizzaOrder(dto);
        var entity = new PizzaOrderEntity(domain);
        var persistedEntity = repository.save(entity);

        return new PizzaOrderCreateResponse(persistedEntity, ESTIMATED_TIME);
    }
}
