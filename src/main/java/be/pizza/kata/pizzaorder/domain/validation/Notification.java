package be.pizza.kata.pizzaorder.domain.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Notification {
    private final List<String> errors = new ArrayList<>();

    private Notification() {
    }

    public static Notification empty() {
        return new Notification();
    }

    public static Notification of(List<String> initialErrors) {
        var notification = new Notification();
        initialErrors.forEach(notification::addError);
        return notification;
    }

    public void addError(String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    @Override
    public boolean equals(Object o) {
        return (this == o) ||
                (o instanceof Notification that && Objects.equals(errors, that.errors));
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        return String.format("Notification{errors=[%s]}", String.join(", ", errors));
    }
}
