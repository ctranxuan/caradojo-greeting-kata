package cara.dojo.kata.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("My kata should")
class MyKataShould {

    @Test
    void simplyFail() {
        fail("this should fail the first time");
    }

    @ParameterizedTest
    @ValueSource(strings = { "bob", "alice" })
    void simplyFailWithParams(String value) {
        Assertions.assertAll("The value is not",
                             () -> assertEquals(value, "John"),
                             () -> assertEquals(value, "Doe"));
    }
}
