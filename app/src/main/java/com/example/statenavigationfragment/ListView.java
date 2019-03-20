package com.example.statenavigationfragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

public interface ListView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMessage();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showList(List<String> items);
}
