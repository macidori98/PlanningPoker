package com.example.planningpoker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpoker.Database.DatabaseHelper;
import com.example.planningpoker.Database.Model.Question;
import com.example.planningpoker.Database.Model.User;
import com.example.planningpoker.Database.Model.Vote;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private Context context;
    private View view;
    private LayoutInflater mInflater;
    private List<Vote> mData;
    private DatabaseHelper db;

    ListAdapter(Context context, List<Vote> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
        db = new DatabaseHelper(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_dot;
        public TextView tv_question;
        public TextView tv_vote;
        public TextView tv_name;

        public MyViewHolder(View view){
            super(view);
            tv_dot = view.findViewById(R.id.tv_dot);
            tv_question = view.findViewById(R.id.tv_question_list);
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
        Question question = db.getQuestion(mData.get(position).getQuestionID());
        int voteValue = mData.get(position).getVoteValue();
        User user = db.getUser(mData.get(position).getUserID());
        holder.tv_name.setText(user.getUserName());
        holder.tv_question.setText(question.getQuestion());
        holder.tv_vote.setText(String.valueOf(voteValue));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




}
