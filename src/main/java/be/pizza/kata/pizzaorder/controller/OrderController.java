package be.pizza.kata;

import be.pizza.kata.pizzaorder.PizzaOrderCreateRequest;
import be.pizza.kata.pizzaorder.PizzaOrderCreateResponse;
import be.pizza.kata.pizzaorder.PizzaOrderService;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final PizzaOrderService pizzaOrderService;

    public OrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaOrderCreateResponse> createPizzaOrder(@RequestBody PizzaOrderCreateRequest dto) {
        var pizzaOrderResponse = pizzaOrderService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaOrderResponse);
    }

    @ExceptionHandler(PizzaOrderException.class)
    public ResponseEntity<String> handlePizzaOrderValidationException(PizzaOrderException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getMessage());
    }}
