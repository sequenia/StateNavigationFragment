package androidx.navigation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class Navigator<D extends NavDestination> {

    public static final class Extras {

    }

    @Retention(RUNTIME)
    @Target({TYPE})
    @SuppressWarnings("UnknownNullness")
    public @interface Name {
        String value();
    }
}
