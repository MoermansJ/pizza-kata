package be.pizza.kata.commons.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Notification {
    // kijjken naar JTires , werk aan de winkel
    private final List<String> errors = new ArrayList<>();

    public Notification() {
    }

    public Notification(List<String> initialErrors) {
        if ( initialErrors.isEmpty() ) {

        }
        this.errors.addAll(initialErrors);
    }

    public void addError(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Error message cannot be null or blank"); // Illegalargument exception = crash the program?
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
