package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;

public class FragmentNavigator extends Navigator<FragmentNavigator.Destination> {

    public FragmentNavigator(@NonNull Context context, @NonNull FragmentManager manager,
                             int containerId) {
        throw new RuntimeException("stub!");
    }

    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle args,
                                   @Nullable NavOptions navOptions,
                                   @Nullable Navigator.Extras navigatorExtras) {
        throw new RuntimeException("stub!");
    }

    public Fragment instantiateFragment(@NonNull Context context,
                                        @NonNull FragmentManager fragmentManager,
                                        @NonNull String className, @Nullable Bundle args) {
        throw new RuntimeException("stub!");
    }

    public static class Destination extends NavDestination {
        public final int getId() {
            throw new RuntimeException("stub!");
        }
    }
}
