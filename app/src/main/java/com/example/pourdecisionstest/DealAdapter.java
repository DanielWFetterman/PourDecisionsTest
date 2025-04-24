package com.example.pourdecisionstest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealViewHolder> {

    private List<Deal> dealList;

    public DealAdapter(List<Deal> dealList) {
        this.dealList = dealList;
    }

    @Override
    public DealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home, parent, false);
        return new DealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DealViewHolder holder, int position) {
        Deal deal = dealList.get(position);
        holder.barNameTextView.setText(deal.getBarName());
        holder.dealDescriptionTextView.setText(deal.getDealDescription());
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }

    public static class DealViewHolder extends RecyclerView.ViewHolder {
        public TextView barNameTextView;
        public TextView dealDescriptionTextView;

        public DealViewHolder(View itemView) {
            super(itemView);
            barNameTextView = itemView.findViewById(R.id.dealBarNameTextView);
            dealDescriptionTextView = itemView.findViewById(R.id.dealDescriptionTextView);
        }
    }
}