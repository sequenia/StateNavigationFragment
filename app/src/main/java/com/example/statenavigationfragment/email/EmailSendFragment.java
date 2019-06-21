package com.example.statenavigationfragment.email;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statenavigationfragment.R;
import com.sequenia.state_navigation_fragment.result.ResultListener;
import com.sequenia.state_navigation_fragment.result.ResultViewModel;

import androidx.navigation.Navigation;

/**
 * Отправка письма
 */
public class EmailSendFragment extends Fragment {

    private ResultViewModel resultModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.email_send_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resultModel = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);

        resultModel.getResult(new ResultListener() {
            @Override
            public void onResult(@NonNull Bundle bundle) {
                boolean isResult = bundle.getBoolean("RESULT_CONTACTS", false);
                if (isResult) {
                    Toast.makeText(getContext(), "CONTACT CHOOSE!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("RESULT_SEND", true);
                resultModel.setResult(bundle);
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
