package com.example.statenavigationfragment.email;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statenavigationfragment.R;
import com.sequenia.state_navigation_fragment.result.ResultListener;
import com.sequenia.state_navigation_fragment.result.ResultViewModel;

import androidx.navigation.Navigation;

/**
 * Главный фрагмент в графе EMAIL
 */
public class EmailFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.email_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ResultViewModel resultModel = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);
        resultModel.getResult(new ResultListener() {
            @Override
            public void onResult(@NonNull Bundle bundle) {
                boolean isSend = bundle.getBoolean("RESULT_SEND", false);
                if (isSend) {
                    Toast.makeText(getContext(), "EMAIL SEND!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.findViewById(R.id.emails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("TYPE", "EMAIL");
                openScreen(R.id.action_emailFragment_to_listFragment, bundle);
            }
        });

        view.findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen(R.id.action_emailFragment_to_emailSendFragment, null);
            }
        });
    }

    private void openScreen(int id, Bundle bundle) {
        View view = getView();
        if (view == null) {
            return;
        }
        Navigation.findNavController(view).navigate(id, bundle);
    }
}
