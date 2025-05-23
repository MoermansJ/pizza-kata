package be.pizza.kata.commons.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Notification {
    private final List<String> errors;

    public Notification() {
        this.errors = new ArrayList<>();
    }

    public Notification(List<String> initialErrors) {
        this.errors = new ArrayList<>(Objects.requireNonNull(initialErrors, "Initial errors cannot be null"));
    }

    public void addError(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Error message cannot be null or blank");
        }
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
