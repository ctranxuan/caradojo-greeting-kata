package cara.dojo.kata.greeting;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static java.lang.String.format;

import io.vavr.collection.Array;
import io.vavr.control.Option;

public final class GreetingService {
    private static final String SAY_HELLO_MY_FRIEND = "Hello, my friend.";

    public String greet(final String... name) {
        return Match(Option.of(name)).of(
                Case($None(), () -> SAY_HELLO_MY_FRIEND),
                Case($Some($(v -> v.length == 2)), () -> format("Hello, %s and %s.", name[0], name[1])),
                Case($Some($(this::isUpperCase)), () -> format("HELLO, %s!", name)),
                Case($(), () -> format("Hello, %s.", name)));
    }

    private boolean isUpperCase(final String... name) {
        return Array.of(name)
                    .toCharSeq()
                    .count(Character::isLowerCase) == 0;
    }
}
