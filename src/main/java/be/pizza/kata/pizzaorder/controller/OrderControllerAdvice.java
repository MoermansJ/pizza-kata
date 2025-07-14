package be.pizza.kata.pizzaorder.controller;

import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderControllerAdvice {

    @ExceptionHandler(PizzaOrderException.class)
    public ResponseEntity<String> handlePizzaOrderException(PizzaOrderException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getMessage());
    }
}
