package cara.dojo.kata.greeting;

import static java.lang.String.format;

import io.vavr.Function1;
import io.vavr.control.Option;

public final class GreetingService {
    private static final String SAY_HELLO_MY_FRIEND = "Hello, my friend.";
    private static final Function1<String, String> SAY_HELLO = s -> format("Hello, %s.", s);

    public String greet(final String name) {
        return Option.of(name)
                     .map(SAY_HELLO)
                     .getOrElse(SAY_HELLO_MY_FRIEND);
    }
}
