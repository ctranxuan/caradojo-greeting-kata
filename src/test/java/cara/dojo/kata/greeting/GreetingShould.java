package cara.dojo.kata.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Greeting should")
class GreetingShould {
    private static GreetService greetService;

    @BeforeAll
    static void setUp() {
        greetService = new GreetService();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Bob", "Alice" })
    @DisplayName("return 'Hello, <name>' (requirement 1)")
    void return_greeting_with_hello(String name) {
        final String greeting = greetService.greet(name);
        assertThat(greeting).isEqualTo("Hello, " + name);
    }
}
