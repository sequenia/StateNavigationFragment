package com.example.statenavigationfragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class ListPresenter extends MvpPresenter<ListView> {

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showMessage();
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(type + " " + i);
        }
        getViewState().showList(items);
    }
}
