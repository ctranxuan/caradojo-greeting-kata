package cara.dojo.kata.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Greeting should")
class GreetingShould {
    private static GreetingService greetingService;

    @BeforeAll
    static void setUp() {
        greetingService = new GreetingService();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Bob", "Alice" })
    @DisplayName("return 'Hello, <name>' (requirement 1)")
    void return_greeting_with_hello(String name) {
        final String greeting = greetingService.greet(name);
        assertThat(greeting).isEqualTo("Hello, " + name + ".");
    }

    @Test
    @DisplayName("return 'Hello, my friend.' when name is null (requirement 2)")
    void return_greeting_friends_when_null_name() {
        final String greeting = greetingService.greet(null);
        assertThat(greeting).isEqualTo("Hello, my friend.");
    }

    @Test
    @DisplayName("return a shout 'HELLO, <name>' (requirement 3)")
    void return_greeting_with_HELLO() {
        final String greeting = greetingService.greet("JERRY");
        assertThat(greeting).isEqualTo("HELLO, JERRY!");
    }

    @Test
    @DisplayName("return 'Hello, <name1> and <name2>., when there are two names")
    void return_greeting_with_2_name() {
        final String greeting = greetingService.greet("Jill", "Jane");
        assertThat(greeting).isEqualTo("Hello, Jill and Jane.");
    }
}
