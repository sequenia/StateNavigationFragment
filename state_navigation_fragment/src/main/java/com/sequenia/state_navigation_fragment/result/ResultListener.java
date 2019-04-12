package com.sequenia.state_navigation_fragment.result;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Слушатель на получение результата
 */
public interface ResultListener {

    /**
     * Результат получен
     *
     * @param bundle - результат
     */
    void onResult(@NonNull Bundle bundle);
}
