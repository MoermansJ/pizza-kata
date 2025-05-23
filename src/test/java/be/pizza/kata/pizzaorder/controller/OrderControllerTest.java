package be.pizza.kata.pizzaorder;

import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveRequest;
import be.pizza.kata.pizzaorder.controller.PizzaOrderSaveResponse;
import be.pizza.kata.pizzaorder.domain.PizzaOrderService;
import be.pizza.kata.pizzaorder.exception.PizzaOrderException;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PizzaOrderService pizzaOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenValidOrderRequest_whenCreatingOrder_thenReturns201CreatedWithPizzaOrderResponse() throws Exception {
        var validOrderRequest = new PizzaOrderSaveRequest("Pepperoni", "Large");
        var mockId = UUID.fromString("00000000-0000-0000-0000-000000000010");
        var mockEstimatedTime = "20 minutes";
        String pizzaOrderResponse = String.format("""
        {
            "orderId" : "%s",
            "estimatedTime" : "%s"
        }""", mockId, mockEstimatedTime);

        Mockito.when((pizzaOrderService.save(Mockito.any(PizzaOrderSaveRequest.class))))
                .thenReturn(new PizzaOrderSaveResponse(mockId, mockEstimatedTime));

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validOrderRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().json(pizzaOrderResponse))
                .andDo(print());
    }

    @Test
    void givenServiceThrowsPizzaOrderValidationException_whenCreatingOrder_thenReturns422UnprocessableEntity() throws Exception {
        var invalidOrderRequest = new PizzaOrderSaveRequest("", "");
        var expectedErrorMessage = """
        Invalid PizzaOrder: Pizza cannot be null or blank. Value: ,
        Size cannot be null or blank. Value: 
        """;

        Mockito.when(pizzaOrderService.save(Mockito.any(PizzaOrderSaveRequest.class)))
                .thenThrow(new PizzaOrderException(expectedErrorMessage));

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidOrderRequest)))
                .andExpect(status().isUnprocessableEntity())
                .andDo(print());
    }
}
