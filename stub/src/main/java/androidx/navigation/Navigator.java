package androidx.navigation;

public class Navigator<D extends NavDestination> {

    public static final class Extras {

    }

    public @interface Name {
        String value();
    }
}
