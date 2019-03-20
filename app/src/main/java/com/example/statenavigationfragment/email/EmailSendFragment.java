package com.example.statenavigationfragment.email;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statenavigationfragment.R;

import androidx.navigation.Navigation;

/**
 * Отправка письма
 */
public class EmailSendFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.email_send_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            boolean isResult = bundle.getBoolean("RESULT", false);
            bundle.remove("RESULT");
            if (isResult) {
                Toast.makeText(getContext(), "CONTACT CHOOSE!", Toast.LENGTH_SHORT).show();
            }
        }

        view.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("RESULT", true);
                Navigation.findNavController(view)
                        .navigate(R.id.action_emailSendFragment_to_emailFragment, bundle);
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
}
