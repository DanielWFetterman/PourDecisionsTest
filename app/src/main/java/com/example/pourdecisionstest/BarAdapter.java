package com.example.pourdecisionstest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder> {

    private List<Bar> barList;

    public BarAdapter(List<Bar> barList) {
        this.barList = barList;
    }

    @Override
    public BarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bar_item, parent, false);
        return new BarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BarViewHolder holder, int position) {
        Bar bar = barList.get(position);
        holder.barNameTextView.setText(bar.getName());
        holder.barDescriptionTextView.setText(bar.getDescription());
    }

    @Override
    public int getItemCount() {
        return barList.size();
    }

    public static class BarViewHolder extends RecyclerView.ViewHolder {
        public TextView barNameTextView;
        public TextView barDescriptionTextView;

        public BarViewHolder(View itemView) {
            super(itemView);
            barNameTextView = itemView.findViewById(R.id.barNameTextView);
            barDescriptionTextView = itemView.findViewById(R.id.barDescriptionTextView);
        }
    }
}