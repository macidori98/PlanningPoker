package com.example.planningpoker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChooseFragment extends Fragment {

    View view;
    Button btn_vote;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose, container, false);

        btn_vote = view.findViewById(R.id.btn_vote);

        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "you clicked on vote", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
