package be.pizza.kata.pizzaorder.domain.validation;

public class Result<T> {

    private final T value;
    private final Notification notification;

    private Result(T value, Notification notification) {
        this.value = value;
        this.notification = notification;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, Notification.empty());
    }

    public static <T> Result<T> failure(Notification notification) {
        return new Result<>(null, notification);
    }

    public T getValue() {
        return value;
    }

    public Notification getNotification() {
        return notification;
    }

    public boolean hasErrors() {
        return notification.hasErrors();
    }
}
