package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigator;

public class NavHostFragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        throw new RuntimeException("stub!");
    }

    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        throw new RuntimeException("stub!");
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        throw new RuntimeException("stub!");
    }

    public final Context requireContext() {
        throw new RuntimeException("stub!");
    }

    final public FragmentManager getChildFragmentManager() {
        throw new RuntimeException("stub!");
    }

    final public int getId() {
        throw new RuntimeException("stub!");
    }
}
