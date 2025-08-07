package be.pizza.kata.pizzaorder.domain.validation;

public class Creation<T> {

    private final T value;
    private final Notification notification;

    private Creation(T value, Notification notification) {
        this.value = value;
        this.notification = notification;
    }

    public static <T> Creation<T> of(T value, Notification notification) {
        return new Creation<>(value, notification);
    }

    public static <T> Creation<T> of(Notification notification) {
        return new Creation<>(null, notification);
    }

    public T getValue() {
        return value;
    }

    public Notification getNotification() {
        return notification;
    }
}
