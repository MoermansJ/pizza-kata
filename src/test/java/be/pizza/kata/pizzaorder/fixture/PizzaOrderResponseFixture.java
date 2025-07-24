package be.pizza.kata.pizzaorder.fixture;

public class PizzaOrderResponseFixture {

    public static String twentyMinutesEstimatedTimeAndValidOrderId() {
        return """
        {
            "orderId" : "00000000-0000-0000-0000-000000000010",
            "estimatedTime" : "20 minutes"
        }""";
    }
}
