package be.pizza.kata.pizzaorder;

import be.pizza.kata.pizzaorder.domain.PizzaOrderService;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderCreateRequestFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderExceptionFixture;
import be.pizza.kata.pizzaorder.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.UUID;

class PizzaOrderServiceTest {

    @Autowired
    private PizzaOrderService pizzaOrderService;

    @MockitoBean
    private PizzaOrderRepository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(PizzaOrderRepository.class);
        this.pizzaOrderService = new PizzaOrderService(repository);
    }

    @Test
    void givenValidPizzaOrderCreateRequest_whenCreate_thenReturnsPizzaOrderSaveResponse() {
        var request = PizzaOrderCreateRequestFixture.validRequest();
        var mockPersistedPizzaOrder = new PizzaOrderEntity();
        mockPersistedPizzaOrder.setId(UUID.fromString("00000000-0000-0000-0000-000000000010"));

        Mockito.when(repository.save(Mockito.any(PizzaOrderEntity.class)))
                .thenReturn(mockPersistedPizzaOrder);

        var actualResponse = pizzaOrderService.save(request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(mockPersistedPizzaOrder.getId().toString(), actualResponse.getOrderId());
    }

    @Test
    void givenInvalidPizzaOrderCreateRequest_whenSave_thenThrowsPizzaOrderException() {
        var invalidPizzaOrderCreateRequest = PizzaOrderCreateRequestFixture.invalidRequest();
        var expectedMessage = PizzaOrderExceptionFixture.pizzaOrderMessageWithInvalidProperties();

        var exception = Assertions.assertThrows(PizzaOrderException.class,
                () -> pizzaOrderService.save(invalidPizzaOrderCreateRequest));
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }
}
