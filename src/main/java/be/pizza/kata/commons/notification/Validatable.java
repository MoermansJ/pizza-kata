package be.pizza.kata.commons.notification;

@FunctionalInterface
public interface Validatable {
    /**
     * Performs validation and returns a Notification containing any errors.
     *
     * @return Notification with validation errors, or empty if valid
     */
    Notification validate();
}
