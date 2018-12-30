package cara.dojo.kata.greeting;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static java.lang.String.format;

import io.vavr.collection.CharSeq;
import io.vavr.control.Option;

public final class GreetingService {
    private static final String SAY_HELLO_MY_FRIEND = "Hello, my friend.";

    public String greet(final String name) {
        return Match(Option.of(name)).of(
                Case($None(), () -> SAY_HELLO_MY_FRIEND),
                Case($Some($(this::isUpperCase)), () -> format("HELLO, %s!", name)),
                Case($(), () -> format("Hello, %s.", name)));
    }

    private boolean isUpperCase(final String name) {
        return CharSeq.of(name)
                      .count(Character::isLowerCase) == 0;
    }
}
