package com.example.planningpoker.Adapters_and_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpoker.Database.DatabaseHelper;
import com.example.planningpoker.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.zip.DataFormatException;

import static com.example.planningpoker.R.color.blue;

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.ViewHolder> {

    private ArrayList<String> mData; // = {"0", "1", "2", "3", "5", "8", "13", "20", "40", "100", "Coffee"};
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private int selectedItem;
    private Context context;
    private DatabaseHelper db;

    ChooseAdapter(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView choose_item;

        ViewHolder(View itemView) {
            super(itemView);
            choose_item = itemView.findViewById(R.id.tv_rec_choose_item);
            //itemView.setOnClickListener(this);
        }

        public void bind(final int position){
            choose_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    selectedItem = position;
                    choose_item.setBackgroundColor(context.getResources().getColor(blue));
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return mData.get(id);
    }

    public int getSelectedPosition(){
        return selectedItem;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.recyclerview_choose_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseAdapter.ViewHolder holder, final int position) {
        holder.choose_item.setText(String.valueOf(getItem(position)));//getItem(position));

        /*holder.choose_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedItem = position;

            }
        });*/
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }
}
