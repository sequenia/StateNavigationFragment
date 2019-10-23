package com.sequenia.state_navigation_fragment.result;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

/**
 * ViewModel для передачи результатов между экранами
 */
public class ResultViewModel extends ViewModel {

    private Bundle resultBundle;

    /**
     * Задание рузальтата
     *
     * @param bundle - результат
     */
    public void setResult(Bundle bundle) {
        resultBundle = bundle;
    }

    /**
     * Получение результата
     *
     * @return результат
     */
    private Bundle getResult() {
        return resultBundle;
    }

    /**
     * Получение результата
     *
     * @param listener слушатель для получения результата
     */
    public void getResult(ResultListener listener) {
        Bundle bundle = getResult();
        if (bundle == null) {
            return;
        }
        setResult(null);
        listener.onResult(bundle);
    }
}
