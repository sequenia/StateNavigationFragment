package com.sequenia.state_navigation_fragment.result.view_models;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory для ViewModel, которые доступны между Activity
 */
public class ResultViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static ResultViewModelFactory viewModelFactory;

    public static ResultViewModelFactory getInstance() {
        return viewModelFactory == null
                ? viewModelFactory = new ResultViewModelFactory() : viewModelFactory;
    }

    private final Map<Class<? extends ViewModel>, ViewModel> mapViewModels = new HashMap<>();

    @NonNull
    @Override
    public <T extends ViewModel> T create(final @NonNull Class<T> modelClass) {

        if (!modelClass.isAssignableFrom(ResultViewModel.class)) {
            return super.create(modelClass);
        }

        if (mapViewModels.containsKey(modelClass)) {
            return (T) mapViewModels.get(modelClass);
        }

        ResultViewModel shareVM = new ResultViewModel();
        mapViewModels.put(modelClass, shareVM);

        return (T) shareVM;
    }
}
