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
 * Главный фрагмент в графе EMAIL
 */
public class EmailFragment extends BaseFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.email_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

    @Override
    public boolean onScreenResultReceive(@NonNull Bundle bundle) {
        boolean isSend = bundle.getBoolean("RESULT_SEND", false);
        if (isSend) {
            Toast.makeText(getContext(), "EMAIL SEND!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
