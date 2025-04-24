package com.example.pourdecisionstest;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BarListActivity extends AppCompatActivity {

    private RecyclerView barRecyclerView;
    private BarAdapter barAdapter;
    private ProgressBar progressBar;
    private List<Bar> barList;
    private final int MAX_BARS = 13; // Limit to 13 bars

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_list);

        barRecyclerView = findViewById(R.id.barRecyclerView);
        progressBar = findViewById(R.id.progressBar);
        barList = new ArrayList<>();
        barAdapter = new BarAdapter(barList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        barRecyclerView.setLayoutManager(layoutManager);
        barRecyclerView.setAdapter(barAdapter);

        // Load initial data (only 13 bars)
        loadInitialData();

        // Remove the scroll listener since we're not doing infinite scrolling
        // barRecyclerView.addOnScrollListener(...); // Remove this block
    }

    private void loadInitialData() {
        progressBar.setVisibility(View.VISIBLE);
        // Generate the bars
        List<Bar> newBars = generateCustomBars();
        barList.addAll(newBars);
        barAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }

    private List<Bar> generateCustomBars() {
        List<Bar> customBars = new ArrayList<>();
        // Customize the data here
        customBars.add(new Bar("The Tipsy Tavern", "Happy Hour: 4-7 PM, $2 off all drafts"));
        customBars.add(new Bar("The Groggy Frog", "Trivia Night Tuesdays, $3 well drinks"));
        customBars.add(new Bar("The Rusty Mug", "Live music every Friday, $4 domestic bottles"));
        customBars.add(new Bar("The Velvet Vine", "Wine Wednesday, half-off all wine"));
        customBars.add(new Bar("The Copper Kettle", "Craft beer specials, $5 appetizers"));
        customBars.add(new Bar("The Jolly Jester", "Karaoke every Thursday, $3 shots"));
        customBars.add(new Bar("The Moonlit Martini", "Martini specials, elegant atmosphere"));
        customBars.add(new Bar("The Barrel Room", "Whiskey tasting flights, cozy setting"));
        customBars.add(new Bar("The Salty Siren", "Seafood and cocktails, waterfront views"));
        customBars.add(new Bar("The Brew House", "Wide selection of local beers, pub fare"));
        customBars.add(new Bar("The Dancing Donkey", "Salsa night, Latin cocktails"));
        customBars.add(new Bar("The Laughing Llama", "Comedy shows, craft cocktails"));
        customBars.add(new Bar("The Hidden Gem", "Speakeasy vibe, unique cocktails"));

        // Ensure we only return up to MAX_BARS
        if (customBars.size() > MAX_BARS) {
            return customBars.subList(0, MAX_BARS);
        } else {
            return customBars;
        }
    }
}