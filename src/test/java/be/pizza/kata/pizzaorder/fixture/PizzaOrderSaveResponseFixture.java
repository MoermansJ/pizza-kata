package be.pizza.kata.pizzaorder.fixture;

public class PizzaOrderSaveResponseFixture {

    public static String responseWithTwentyMinutesEstimatedTimeAndOrderId() {
        return """
        {
            "orderId" : "00000000-0000-0000-0000-000000000010",
            "estimatedTime" : "20 minutes"
        }""";
    }
}
