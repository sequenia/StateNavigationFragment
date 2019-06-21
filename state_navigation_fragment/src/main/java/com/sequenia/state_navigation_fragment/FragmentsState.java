package com.sequenia.state_navigation_fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.HashMap;

/**
 * Класс для сохранения и восстановления состояний фрагмента
 */
class FragmentsState {

    private FragmentManager fragmentManager;
    private HashMap<Integer, Fragment.SavedState> fragmentSavedStates = new HashMap<>();

    FragmentsState(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    /**
     * Восстановление состояния фрагмента
     *
     * @param fragment - кому восстановить
     * @param key      - ключ, по которому сохраненно состояние
     */
    void restoreState(Fragment fragment, Integer key) {
        if (fragmentSavedStates.containsKey(key)) {
            if (!fragment.isAdded()) {
                fragment.setInitialSavedState(fragmentSavedStates.get(key));
            }
        }
    }

    /**
     * Сохранить состояние фрагмента
     *
     * @param fragment - чье состояние сохраняем
     * @param key      - ключ, по которому будет храниться это состояние
     */
    void saveState(Fragment fragment, Integer key) {
        if (fragment != null && fragment.isAdded()) {
            fragmentSavedStates.put(key, fragmentManager.saveFragmentInstanceState(fragment));
        }
    }

    /**
     * @return - возвращает сохранненные состояния
     */
    Bundle saveStates() {
        Bundle state = new Bundle();

        for (Integer key : fragmentSavedStates.keySet()) {
            state.putParcelable(key.toString(), fragmentSavedStates.get(key));
        }

        return state;
    }

    /**
     * Восстанавливает сохраненные состояния
     *
     * @param savedState - сохраненные состояния
     */
    void restoreStates(Bundle savedState) {
        fragmentSavedStates.clear();
        savedState.setClassLoader(this.getClass().getClassLoader());
        for (String key : savedState.keySet()) {
            fragmentSavedStates.put(Integer.valueOf(key),
                    (Fragment.SavedState) savedState.getParcelable(key));
        }
    }
}
