package com.example.statenavigationfragment.fragments.email;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.statenavigationfragment.R;
import com.example.statenavigationfragment.base.BaseFragment;

/**
 * Отправка письма
 */
public class EmailSendFragment extends BaseFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.email_send_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("RESULT_SEND", true);
                setScreenResult(bundle);
                Navigation.findNavController(view).navigate(R.id.action_emailSendFragment_to_emailFragment, bundle);
            }
        });

        view.findViewById(R.id.choose_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_emailSendFragment_to_contactsFragment);
            }
        });
    }

    @Override
    public boolean onScreenResultReceive(@NonNull Bundle bundle) {
        boolean isResult = bundle.getBoolean("RESULT_CONTACTS", false);
        if (isResult) {
            Toast.makeText(getContext(), "CONTACT CHOOSE!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
