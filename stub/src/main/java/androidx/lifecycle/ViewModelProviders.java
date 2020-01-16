package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class ViewModelProviders {

    public static ViewModelProvider of(@NonNull FragmentActivity activity) {
        throw new RuntimeException("stub!");
    }

    public static ViewModelProvider of(@NonNull FragmentActivity activity,
                                       @Nullable ViewModelProvider.Factory factory) {
        throw new RuntimeException("stub!");
    }
}
