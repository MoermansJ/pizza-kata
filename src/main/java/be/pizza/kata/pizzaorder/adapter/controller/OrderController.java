package be.pizza.kata.pizzaorder.adapter.controller;

import be.pizza.kata.pizzaorder.usecase.OrderPizzaUsecase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderPizzaUsecase usecase;
    private final ObjectMapper mapper;

    public OrderController(OrderPizzaUsecase usecase, ObjectMapper mapper) {
        this.usecase = usecase;
        this.mapper = mapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPizzaOrder(@RequestBody PizzaOrderRequestResource resource) {
        // wat doen met response type? String? En hoe dan mappen? Json processing exception afhandelen?
        var request = new PizzaOrderRequest(resource.pizza(), resource.size());
        var creation = usecase.execute(request);

        if (creation.getNotification().hasErrors()) {
            var errors = mapper.writeValueAsString(creation.getNotification().getErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        var response = mapper.writeValueAsString(creation.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }

}
