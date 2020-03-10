package com.example.statenavigationfragment.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.sequenia.state_navigation_fragment.result.ScreenResultHandler;

public class ResultActivity extends AppCompatActivity implements ScreenResultHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle();
        bundle.putString("A", "result");
        setScreenResult(bundle);
        finish();
    }

    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
