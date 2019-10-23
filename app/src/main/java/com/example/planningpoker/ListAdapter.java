package com.example.planningpoker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpoker.Database.Model.Vote;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private Context context;
    private List<Vote> votesHobby;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_dot;
        public TextView tv_question;
        public TextView tv_vote;
        public TextView tv_name;

        public MyViewHolder(View view){
            super(view);
            tv_dot = view.findViewById(R.id.tv_dot);
            tv_question = view.findViewById(R.id.tv_question);
            tv_vote = view.findViewById(R.id.tv_vote);
            tv_name = view.findViewById(R.id.tv_name);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//miket irjon ki

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
