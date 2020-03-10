package com.example.statenavigationfragment.base;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.sequenia.state_navigation_fragment.result.ScreenResultHandler;

public abstract class BaseFragment extends MvpAppCompatFragment implements ScreenResultHandler {

    @Override
    public void onResume() {
        super.onResume();
        checkReceivedScreenResult();
    }
}
