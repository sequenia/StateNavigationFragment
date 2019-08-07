package com.sequenia.state_navigation_fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

/**
 * FragmentNavigator с сохранением состояний фрагментов
 * <p>
 * в разметке задается по имени state_fragment
 */
@Navigator.Name("state_fragment")
public class FragmentStateNavigator extends FragmentNavigator {

    /**
     * true восстановить имеющееся состояние
     */
    public final static String NEED_TO_RESTORE = "NEED_TO_RESTORE";

    private final static String DESTINATION_ID = "DESTINATION_ID";

    private FragmentManager manager;
    private int containerId;

    /**
     * Умеет работать с состояниями фрагмента
     * - сохранять
     * - восстанавливать
     */
    private FragmentsState fragmentsState;

    public FragmentStateNavigator(@NonNull Context context, @NonNull FragmentManager manager,
                                  int containerId) {
        super(context, manager, containerId);
        this.fragmentsState = new FragmentsState(manager);
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
        args.putInt(DESTINATION_ID, destination.getId());
        saveState(getCurrentFragment());
        return super.navigate(destination, args, navOptions, navigatorExtras);
    }

    @NonNull
    @Override
    public Fragment instantiateFragment(@NonNull Context context,
                                        @NonNull FragmentManager fragmentManager,
                                        @NonNull String className, @Nullable Bundle args) {
        boolean needToRestore = args != null && args.getBoolean(NEED_TO_RESTORE, true);
        if (args != null && !needToRestore) {
            args.remove(NEED_TO_RESTORE);
        }
        Fragment fragment = super.instantiateFragment(context, fragmentManager, className, args);
        if (needToRestore) {
            fragmentsState.restoreState(fragment, args.getInt(DESTINATION_ID));
        } else {
            fragment.setArguments(args);
        }
        return fragment;
    }

    /**
     * @return - все сохраненные состояния
     */
    Bundle getStatesBundle() {
        return fragmentsState.saveStates();
    }

    /**
     * Восстановление состояний всех сохраненных фрагментов
     *
     * @param bundle - все сохраненные состояния
     */
    void restoreStates(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        fragmentsState.restoreStates(bundle);
    }

    /**
     * Сохранение состояние текущего фрагмента
     *
     * @param currentFragment - верхний фрагмент в стеке (текущий)
     */
    private void saveState(Fragment currentFragment) {
        if (currentFragment == null) {
            return;
        }
        Bundle currentArgs = currentFragment.getArguments();
        if (currentArgs != null) {
            fragmentsState.saveState(currentFragment, currentArgs.getInt(DESTINATION_ID));
        }
    }

    /**
     * @return - верхний фрагмент в стеке (текущий)
     */
    private Fragment getCurrentFragment() {
        return manager.findFragmentById(containerId);
    }
}
