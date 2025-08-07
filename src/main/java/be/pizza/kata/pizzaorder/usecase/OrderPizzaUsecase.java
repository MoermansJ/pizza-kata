package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.domain.model.PizzaOrderFactory;
import be.pizza.kata.pizzaorder.domain.validation.Result;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderPizzaUsecase {

    private final String estimatedTime;
    private final PizzaOrderRepository repository;

    public OrderPizzaUsecase(PizzaOrderRepository repository, @Value("${order.pizza.estimated-time}") String estimatedTime) {
        this.repository = repository;
        this.estimatedTime = estimatedTime;
    }

    public Result<PizzaOrderResponse> execute(PizzaOrderRequest request) {
        var creation = PizzaOrderFactory.create(request);

        if (creation.getNotification().hasErrors()) {
            var notification = creation.getNotification();
            return Result.failure(notification);
        }

        var order = creation.getValue();
        var unsaved = new PizzaOrderEntity(order);
        var saved = repository.save(unsaved);
        var response = new PizzaOrderResponse(saved, estimatedTime);

        return Result.success(response);
    }
}
