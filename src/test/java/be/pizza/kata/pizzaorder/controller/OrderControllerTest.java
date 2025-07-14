package be.pizza.kata.pizzaorder.controller;

import be.pizza.kata.pizzaorder.domain.PizzaOrderService;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderExceptionFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderSaveRequestFixture;
import be.pizza.kata.pizzaorder.fixture.PizzaOrderSaveResponseFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PizzaOrderService pizzaOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenValidRequest_whenSavingOrder_thenReturns201CreatedWithPizzaOrderResponse() throws Exception {
        var request = PizzaOrderSaveRequestFixture.mediumMargheritaRequest();
        var response = PizzaOrderSaveResponseFixture.responseWithTwentyMinutesEstimatedTimeAndOrderId();

        Mockito.when((pizzaOrderService.save(Mockito.any(PizzaOrderSaveRequest.class))))
                .thenReturn(new PizzaOrderSaveResponse(UUID.fromString("00000000-0000-0000-0000-000000000010"), "20 minutes"));

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().json(response));
    }

    @Test
    void givenInvalidRequest_whenSavingOrder_thenReturns422UnprocessableEntity() throws Exception {
        var request = PizzaOrderSaveRequestFixture.blankPizzaAndBlankSizeRequest();
        var expectedMessage = PizzaOrderExceptionFixture.blankPizzaAndBlankPizzaSizeMessage();

        Mockito.when(pizzaOrderService.save(Mockito.any(PizzaOrderSaveRequest.class)))
                .thenThrow(new PizzaOrderException(expectedMessage));

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().string(expectedMessage));
    }
}
