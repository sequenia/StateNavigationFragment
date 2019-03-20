package com.example.statenavigationfragment;

import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface ListView extends MvpView {

    void showList(List<String> items);
}
