package be.pizza.kata.pizzaorder.controller;

import be.pizza.kata.pizzaorder.domain.PizzaOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final PizzaOrderService service;

    public OrderController(PizzaOrderService service) {
        this.service = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaOrderSaveResponse> createPizzaOrder(@RequestBody PizzaOrderSaveRequest dto) {
        var pizzaOrderResponse = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaOrderResponse);
    }

}
