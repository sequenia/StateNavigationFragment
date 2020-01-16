package androidx.lifecycle;

import androidx.annotation.NonNull;

public class ViewModelProvider {

    public <T extends ViewModel> T get(@NonNull Class<T> modelClass) {
        throw new RuntimeException("stub!");
    }

    public static class NewInstanceFactory implements Factory {
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            throw new RuntimeException("stub!");
        }
    }

    public interface Factory {
        <T extends ViewModel> T create(@NonNull Class<T> modelClass);
    }
}
