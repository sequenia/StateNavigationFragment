package com.example.statenavigationfragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class ListPresenter extends MvpPresenter<ListView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("ITEM " + i);
        }
        getViewState().showList(items);
    }
}
