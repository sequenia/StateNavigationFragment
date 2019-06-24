package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class Fragment {

    public Bundle getArguments() {
        throw new RuntimeException("stub!");
    }

    final public boolean isAdded() {
        throw new RuntimeException("stub!");
    }

    public void setInitialSavedState(@Nullable SavedState state) {
        throw new RuntimeException("stub!");
    }

    public static class SavedState implements Parcelable {

        protected SavedState(Parcel in) {
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
        }
    }
}
