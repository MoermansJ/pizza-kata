package be.pizza.kata.commons.testcontainers;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;


public class PostgreSQLTestContainer {
    @Container
    private static final PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>(DockerImageName.parse("pgvector/pgvector:pg16"))
                    .withDatabaseName("test-db")
                    .withUsername("test")
                    .withPassword("test");

    static {
        container.start();
    }

    public static PostgreSQLContainer<?> getInstance() {
        return container;
    }
}
