package com.example.pourdecisionstest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pourdecisionstest.Deal;
import com.example.pourdecisionstest.DealAdapter;
import com.example.pourdecisionstest.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView dealRecyclerView;
    private DealAdapter dealAdapter;
    private List<Deal> dealList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Set up the RecyclerView for deals
        dealRecyclerView = binding.dealRecyclerView;
        dealList = new ArrayList<>();
        dealAdapter = new DealAdapter(dealList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dealRecyclerView.setLayoutManager(layoutManager);
        dealRecyclerView.setAdapter(dealAdapter);

        // Load the deals
        loadDeals();

        return root;
    }

    private void loadDeals() {
        List<Deal> newDeals = generateCustomDeals();
        dealList.addAll(newDeals);
        dealAdapter.notifyDataSetChanged();
    }

    private List<Deal> generateCustomDeals() {
        List<Deal> customDeals = new ArrayList<>();
        // Customize the data here
        customDeals.add(new Deal("The Tipsy Tavern", "Happy Hour: 4-7 PM, $2 off all drafts"));
        customDeals.add(new Deal("The Groggy Frog", "Trivia Night Tuesdays, $3 well drinks"));
        customDeals.add(new Deal("The Rusty Mug", "Live music every Friday, $4 domestic bottles"));
        customDeals.add(new Deal("The Velvet Vine", "Wine Wednesday, half-off all wine"));
        customDeals.add(new Deal("The Copper Kettle", "Craft beer specials, $5 appetizers"));
        customDeals.add(new Deal("The Jolly Jester", "Karaoke every Thursday, $3 shots"));
        customDeals.add(new Deal("The Moonlit Martini", "Martini specials, elegant atmosphere"));
        customDeals.add(new Deal("The Barrel Room", "Whiskey tasting flights, cozy setting"));
        customDeals.add(new Deal("The Salty Siren", "Seafood and cocktails, waterfront views"));
        customDeals.add(new Deal("The Brew House", "Wide selection of local beers, pub fare"));
        customDeals.add(new Deal("The Dancing Donkey", "Salsa night, Latin cocktails"));
        customDeals.add(new Deal("The Laughing Llama", "Comedy shows, craft cocktails"));