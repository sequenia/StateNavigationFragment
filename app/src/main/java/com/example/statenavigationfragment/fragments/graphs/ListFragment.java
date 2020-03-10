package com.example.statenavigationfragment.fragments.graphs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.statenavigationfragment.ListAdapter;
import com.example.statenavigationfragment.ListPresenter;
import com.example.statenavigationfragment.ListView;
import com.example.statenavigationfragment.R;

import java.util.List;


public class ListFragment extends MvpAppCompatFragment implements ListView {

    private ListAdapter adapter;

    @InjectPresenter
    ListPresenter presenter;

    @ProvidePresenter
    ListPresenter providerListPresenter() {
        ListPresenter presenter = new ListPresenter();
        Bundle arg = getArguments();
        if (arg != null) {
            presenter.setType(arg.getString("TYPE", "ITEM"));
        }
        return presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView list = view.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        adapter = new ListAdapter(getLayoutInflater());
        list.setAdapter(adapter);
    }

    @Override
    public void showMessage() {
        Toast.makeText(getContext(), "FIRST",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<String> items) {
        adapter.setItems(items);
    }
}
