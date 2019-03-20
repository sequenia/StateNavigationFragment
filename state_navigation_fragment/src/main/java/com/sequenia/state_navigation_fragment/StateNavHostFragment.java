package com.sequenia.state_navigation_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

/**
 * Host, работающий с FragmentStateNavigator
 */
public class StateNavHostFragment extends NavHostFragment {

    private final static String FRAGMENT_STATE = "FRAGMENT_STATE";

    private FragmentStateNavigator navigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            navigator.restoreStates(savedInstanceState.getBundle(FRAGMENT_STATE));
        }
    }

    @NonNull
    @Override
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        return navigator = new FragmentStateNavigator(requireContext(),
                getChildFragmentManager(), getId());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(FRAGMENT_STATE, navigator.getStatesBundle());
    }
}

