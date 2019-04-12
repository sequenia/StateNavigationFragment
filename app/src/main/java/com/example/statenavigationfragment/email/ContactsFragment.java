package com.example.statenavigationfragment.email;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.statenavigationfragment.R;
import com.sequenia.state_navigation_fragment.result.ResultViewModel;

import androidx.navigation.Navigation;


public class ContactsFragment extends Fragment {

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
                ResultViewModel result = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("RESULT_CONTACTS", true);
                result.setResult(bundle);
                Navigation.findNavController(view)
                        .navigate(R.id.action_contactsFragment_to_emailSendFragment);
            }
        });
    }
}
