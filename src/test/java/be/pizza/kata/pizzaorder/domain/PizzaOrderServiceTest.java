package be.pizza.kata.pizzaorder.domain;

import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderSaveRequestFixture;
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
    void givenValidPizzaOrderSaveRequest_whenCreate_thenReturnsPizzaOrderSaveResponse() {
        var request = PizzaOrderSaveRequestFixture.mediumMargheritaRequest();
        var dummySaved = new PizzaOrderEntity();
        dummySaved.setId(UUID.fromString("00000000-0000-0000-0000-000000000010"));

        Mockito.when(repository.save(Mockito.any(PizzaOrderEntity.class)))
                .thenReturn(dummySaved);

        var actualResponse = pizzaOrderService.save(request);
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(dummySaved.getId().toString(), actualResponse.getOrderId());
    }

    @Test
    void givenInvalidPizzaOrderSaveRequest_whenSave_thenThrowsPizzaOrderException() {
        var invalidRequest = PizzaOrderSaveRequestFixture.blankPizzaAndBlankSizeRequest();
        var expectedMessage = PizzaOrderExceptionFixture.blankPizzaAndBlankPizzaSizeMessage();

        var exception = Assertions.assertThrows(PizzaOrderException.class,
                () -> pizzaOrderService.save(invalidRequest));
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }


}
