package com.sequenia.state_navigation_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.HashMap;

/**
 * Класс для сохранения и восстановления состояний фрагмента
 */
class FragmentState {

    private FragmentManager fragmentManager;
    private HashMap<Integer, Fragment.SavedState> fragmentSavedStates = new HashMap<>();

    FragmentState(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    void restoreState(Fragment fragment, Integer key) {
        if (fragmentSavedStates.containsKey(key)) {
            if (!fragment.isAdded()) {
                fragment.setInitialSavedState(fragmentSavedStates.get(key));
            }
        }
    }

    void saveState(Fragment fragment, Integer key) {
        if (fragment != null && fragment.isAdded()) {
            fragmentSavedStates.put(key, fragmentManager.saveFragmentInstanceState(fragment));
        }
    }

    Bundle saveHelperState() {
        Bundle state = new Bundle();

        for (Integer key : fragmentSavedStates.keySet()) {
            state.putParcelable(key.toString(), fragmentSavedStates.get(key));
        }

        return state;
    }

    void restoreHelperState(Bundle savedState) {
        fragmentSavedStates.clear();
        savedState.setClassLoader(this.getClass().getClassLoader());
        for (String key : savedState.keySet()) {
            fragmentSavedStates.put(Integer.valueOf(key),
                    (Fragment.SavedState) savedState.getParcelable(key));
        }
    }

    void removeState(Integer key) {
        fragmentSavedStates.remove(key);
    }
}
