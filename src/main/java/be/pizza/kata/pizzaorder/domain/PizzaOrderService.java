package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.commons.notification.Validate;
import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveRequest;
import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveResponse;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

    private static final String ESTIMATED_TIME = "20 minutes";
    private static final String DELIMITER = "," + System.lineSeparator();
    private final PizzaOrderRepository repository;

    public PizzaOrderService(PizzaOrderRepository repository) {
        this.repository = repository;
    }

    public PizzaOrderSaveResponse save(PizzaOrderSaveRequest dto) {
        var dtoValidation = dto.validate();

        if (dtoValidation.hasErrors()) {
            var message = String.join(DELIMITER, dtoValidation.getErrors());
            throw new PizzaOrderException(message);
        }

        var domain = new PizzaOrder(dto);
        var domainValidation = domain.validate();

        if (domainValidation.hasErrors()) {
            var message = String.join(DELIMITER, domainValidation.getErrors());
            throw new PizzaOrderException(message);
        }

        var unsaved = new PizzaOrderEntity(
                domain.getPizza().getValue(),
                domain.getSize().getValue());

        var saved = repository.save(unsaved);

        return new PizzaOrderSaveResponse(saved.getId(), ESTIMATED_TIME);
    }
}
