package com.example.myworkpoint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ExampleViewHolder>{

    private ArrayList<ListShow> mExampleList;
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list,parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ListShow currentItem = mExampleList.get(position);
        holder.mTextView.setText(currentItem.getTime());
        holder.mTextView1.setText(currentItem.getShow());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;
        public TextView mTextView1;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.time_show);
            mTextView1 = itemView.findViewById(R.id.list_show);
        }
    }

    public MyAdapter(ArrayList<ListShow> exampleList){
        mExampleList = exampleList;
    }


}
