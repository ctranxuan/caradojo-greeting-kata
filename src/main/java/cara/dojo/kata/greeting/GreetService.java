package cara.dojo.kata.greeting;

import static java.lang.String.format;

public final class GreetService {
    public String greet(final String name) {
        return format("Hello, %s", name);
    }
}
