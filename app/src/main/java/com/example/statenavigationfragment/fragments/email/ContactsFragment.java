package com.example.statenavigationfragment.fragments.email;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.statenavigationfragment.R;
import com.example.statenavigationfragment.activities.ResultActivity;
import com.example.statenavigationfragment.base.BaseFragment;

public class ContactsFragment extends BaseFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.selected).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ResultActivity.class));
            }
        });
    }

    @Override
    public boolean onScreenResultReceive(@NonNull Bundle bundle) {
        Toast.makeText(getContext(), "RESULT", Toast.LENGTH_SHORT).show();
        return true;
    }
}
