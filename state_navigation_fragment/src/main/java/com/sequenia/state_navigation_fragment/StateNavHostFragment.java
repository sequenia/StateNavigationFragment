package com.sequenia.state_navigation_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

public class StateNavHostFragment extends NavHostFragment {

    private final static String FRAGMENT_STATE = "FRAGMENT_STATE";

    private StateNavigator navigator;
    private int backStackEntryCount = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            navigator.restoreHelperState(savedInstanceState.getBundle(FRAGMENT_STATE));
        }

        getChildFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        int backStackNewEntryCount = getChildFragmentManager()
                                .getBackStackEntryCount();
                        if (backStackNewEntryCount < backStackEntryCount) {
                            navigator.removeFragmentState();
                        }
                        backStackEntryCount = backStackNewEntryCount;
                    }
                });
    }

    @NonNull
    @Override
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        return navigator = new StateNavigator(requireContext(), getChildFragmentManager(), getId());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(FRAGMENT_STATE, navigator.getFragmentStateBundle());
    }
}

