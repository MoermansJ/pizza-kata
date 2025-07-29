package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.domain.model.PizzaOrderFactory;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderRequestFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderExceptionFixture;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(PizzaOrderServiceTestConfig.class)
class PizzaOrderServiceTest {

    @Autowired
    private PizzaOrderService service;

    @MockitoBean
    private PizzaOrderRepository repository;

    @Test
    void givenValidPizzaOrderRequest_whenCreate_thenReturnsPizzaOrderResponse() {
        var request = PizzaOrderRequestFixture.mediumMargheritaRequest();
        var dummySaved = new PizzaOrderEntity();
        dummySaved.setId(UUID.fromString("00000000-0000-0000-0000-000000000010"));

        when(repository.save(any(PizzaOrderEntity.class))).thenReturn(dummySaved);

        var response = service.save(request);
        assertNotNull(response);
        assertEquals(dummySaved.getId().toString(), response.orderId());
    }

    @Test
    void givenInvalidPizzaOrderRequest_whenSave_thenThrowsPizzaOrderException() {
        var invalidRequest = PizzaOrderRequestFixture.blankPizzaAndBlankSizeRequest();
        var expectedMessage = PizzaOrderExceptionFixture.blankPizzaAndBlankPizzaSizeMessage();

        var exception = assertThrows(PizzaOrderException.class,
                () -> PizzaOrderFactory.createFrom(invalidRequest));
        assertEquals(expectedMessage, exception.getMessage());
    }
}
