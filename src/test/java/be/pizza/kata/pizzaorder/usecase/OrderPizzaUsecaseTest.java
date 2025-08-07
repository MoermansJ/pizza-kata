package be.pizza.kata.pizzaorder.usecase;

import be.pizza.kata.pizzaorder.fixture.PizzaOrderRequestFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderValidationErrorFixture;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(OrderPizzaUsecaseTestConfig.class)
class OrderPizzaUsecaseTest {

    @Autowired
    private OrderPizzaUsecase usecase;

    @MockitoBean
    private PizzaOrderRepository repository;

    @Test
    void givenValidPizzaOrderRequest_whenOrderingPizza_thenReturnsResultWithEmptyNotification() {
        var request = PizzaOrderRequestFixture.mediumMargherita();
        var dummyOrderId = UUID.fromString("00000000-0000-0000-0000-000000000010");
        var dummySaved = PizzaOrderEntity.builder()
                .id(dummyOrderId)
                .build();

        when(repository.save(any(PizzaOrderEntity.class))).thenReturn(dummySaved);

        var result = usecase.execute(request);

        assertThat(result.getNotification().hasErrors()).isFalse();
        assertThat(result.getValue()).isNotNull();
        assertThat(result.getValue().getOrderId()).isEqualTo(dummyOrderId);
        assertThat(result.getValue().getEstimatedTime()).isEqualTo("20 minutes");
    }

    @Test
    void givenInvalidPizzaOrderRequest_whenOrderingPizza_thenReturnsFailedResultWithNotification() {
        var invalidRequest = PizzaOrderRequestFixture.emptyPizzaAndEmptyPizzaSize();
        var expectedErrors = PizzaOrderValidationErrorFixture.nullPizzaAndNullPizzaSizeErrors();

        var result = usecase.execute(invalidRequest);

        assertThat(result.getValue()).isNull();
        assertThat(result.getNotification().hasErrors()).isTrue();
        assertThat(result.getNotification().getErrors()).containsAll(expectedErrors);
    }
}
