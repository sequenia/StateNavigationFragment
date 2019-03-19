package com.sequenia.state_navigation_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

@Navigator.Name("state_fragment")
public class StateNavigator extends FragmentNavigator {

    private final static String DESTINATION_ID = "DESTINATION_ID";

    private FragmentManager manager;
    private int containerId;

    private FragmentState fragmentState;
    private int fragmentId;

    public StateNavigator(@NonNull Context context, @NonNull FragmentManager manager,
                          int containerId) {
        super(context, manager, containerId);
        this.fragmentState = new FragmentState(manager);
        this.manager = manager;
        this.containerId = containerId;
    }

    @Nullable
    @Override
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle args,
                                   @Nullable NavOptions navOptions,
                                   @Nullable Navigator.Extras navigatorExtras) {
        if (args == null) {
            args = new Bundle();
        }
        fragmentId = destination.getId();
        args.putInt(DESTINATION_ID, destination.getId());
        saveFragmentState(getCurrentFragment());
        return super.navigate(destination, args, navOptions, navigatorExtras);
    }

    @NonNull
    @Override
    public Fragment instantiateFragment(@NonNull Context context,
                                        @NonNull FragmentManager fragmentManager,
                                        @NonNull String className, @Nullable Bundle args) {
        Fragment fragment = super.instantiateFragment(context, fragmentManager, className, args);
        if (args != null) {
            fragmentState.restoreState(fragment, args.getInt(DESTINATION_ID));
        }
        return fragment;
    }

    void removeFragmentState() {
        fragmentState.removeState(fragmentId);
    }

    Bundle getFragmentStateBundle() {
        return fragmentState.saveHelperState();
    }

    void restoreHelperState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        fragmentState.restoreHelperState(bundle);
    }

    private void saveFragmentState(Fragment currentFragment) {
        if (currentFragment != null) {
            Bundle currentArgs = currentFragment.getArguments();
            if (currentArgs != null) {
                fragmentState.saveState(currentFragment, currentArgs.getInt(DESTINATION_ID));
            }
        }
    }

    private Fragment getCurrentFragment() {
        return manager.findFragmentById(containerId);
    }
}
