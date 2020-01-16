package com.sequenia.state_navigation_fragment.result.view_models;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.sequenia.state_navigation_fragment.result.ResultListener;

/**
 * ViewModel для передачи результатов между экранами
 */
public class ResultViewModel extends ViewModel {

    private Bundle resultBundle;

    /**
     * Задание рузальтата
     *
     * @param resultBundle       результат
     */
    public void setResult(Bundle resultBundle) {
        this.resultBundle = resultBundle;
    }

    /**
     * Получение результата
     *
     * @param listener      слушатель для получения результата
     */
    public void getResult(ResultListener listener) {
        Bundle bundle = getResult();
        if (bundle == null) {
            return;
        }
        listener.onResult(bundle);
    }

    /**
     * Получение результата
     *
     * @return результат
     */
    private Bundle getResult() {
        return resultBundle;
    }
}
