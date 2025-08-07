package be.pizza.kata.pizzaorder.adapter;

import be.pizza.kata.pizzaorder.adapter.controller.PizzaOrderRequest;
import be.pizza.kata.pizzaorder.domain.validation.Notification;
import be.pizza.kata.pizzaorder.domain.validation.Result;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderValidationErrorFixture;
import be.pizza.kata.pizzaorder.usecase.OrderPizzaUsecase;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderRequestResourceFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderResponseFixture;
import be.pizza.kata.pizzaorder.usecase.PizzaOrderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderPizzaUsecase usecase;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void givenValidRequest_whenOrderingPizza_thenReturns201CreatedWithPizzaOrderResponse() throws Exception {
        var requestResource = PizzaOrderRequestResourceFixture.mediumMargherita();
        var orderResponse = PizzaOrderResponseFixture.twentyMinutesEstimatedTimeAndValidOrderId();
        var expectedResult = Result.success(orderResponse);
        var expectedContent = mapper.writeValueAsString(orderResponse);

        when(usecase.execute(any(PizzaOrderRequest.class))).thenReturn(expectedResult);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestResource)))
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedContent));
    }

    @Test
    void givenInvalidRequest_whenOrderingPizza_thenReturns400BadRequest() throws Exception {
        var requestResource = PizzaOrderRequestResourceFixture.emptyPizzaAndEmptySize();
        var expectedNotification = Notification.of(PizzaOrderValidationErrorFixture.nullPizzaAndNullPizzaSizeErrors());
        Result<PizzaOrderResponse> expectedResult = Result.failure(expectedNotification); // var causes type inference issues in the IDE
        var expectedContent = mapper.writeValueAsString(expectedNotification.getErrors());

        Mockito.when(usecase.execute(Mockito.any(PizzaOrderRequest.class))).thenReturn(expectedResult);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestResource)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedContent));
    }
}
