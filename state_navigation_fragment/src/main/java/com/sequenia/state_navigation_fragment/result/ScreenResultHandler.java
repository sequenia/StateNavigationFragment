package com.sequenia.state_navigation_fragment.result;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.sequenia.state_navigation_fragment.result.view_models.ResultViewModel;
import com.sequenia.state_navigation_fragment.result.view_models.ResultViewModelFactory;

/**
 * Обработчик результата между экранами:
 * {@link android.app.Activity}
 * {@link androidx.fragment.app.Fragment}
 */
public interface ScreenResultHandler {

    FragmentActivity getActivity();

    /**
     * Отдать результат экрана
     *
     * @param bundle результата экрана
     * @return true удалить результат из хранилища, false - результат остался в хранилище
     */
    default boolean onScreenResultReceive(@NonNull Bundle bundle) {
        return false;
    }

    /**
     * Проверка полученного результата с других экранов
     */
    default void checkReceivedScreenResult() {
        ResultViewModel resultModel = getResultViewModel();
        if (resultModel == null) {
            return;
        }
        resultModel.getResult(new ResultListener() {
            @Override
            public void onResult(@NonNull Bundle bundle) {
                boolean resultReceived = onScreenResultReceive(bundle);
                if (resultReceived) {
                    setScreenResult(null);
                }
            }
        });
    }

    /**
     * Задание результата экрана
     *
     * @param resultBundle результат
     */
    default void setScreenResult(Bundle resultBundle) {
        ResultViewModel resultModel = getResultViewModel();
        if (resultModel == null) {
            return;
        }
        resultModel.setResult(resultBundle);
    }

    /**
     * Получение ViewModel
     *
     * @return ViewModel
     */
    default ResultViewModel getResultViewModel() {
        FragmentActivity fragmentActivity = getActivity();
        if (fragmentActivity == null) {
            return null;
        }
        return new ViewModelProvider(fragmentActivity, ResultViewModelFactory.getInstance())
                .get(ResultViewModel.class);
    }
}
