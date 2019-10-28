package com.example.planningpoker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpoker.Database.DatabaseHelper;
import com.example.planningpoker.Database.Model.User;
import com.example.planningpoker.Database.Model.Vote;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    public static final String TAG = "LIST_FRAG";


    private View view;
    private RecyclerView myRecyclerView;
    private LayoutInflater mInflater;
    private ListAdapter myAdapter;
    private List<Vote> mData;
    private DatabaseHelper db;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        myRecyclerView = view.findViewById(R.id.recycler_view_list);
        db = new DatabaseHelper(getContext());
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        User user = db.getUser(LoginActivity.loggedUserName);
        mData = db.getVotes(user.getId());

        //itt kell betenni az adatokat az mdataba


        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new ListAdapter(getContext(), mData);
        //myAdapter.setClickListener((ChooseAdapter.ItemClickListener) getActivity());
        myRecyclerView.setAdapter(myAdapter);

    }
}
