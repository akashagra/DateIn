package com.example.avma1997.datein;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.login.widget.LoginButton;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

// Matching Algorithm
// For each common like 10 points, user location : 100 points within 10 kms ,50 points same city ,25 points same country,0->Otherwise
        // Hashtags: Same Hashtag-> 50 points
        // Top 10 movies->  For each common movie: 20 points
        // Caste and Religion : Same Caste->50 points , Same Religion->25 points
        // Same Work( if Working)-> 50 points
        // Same Course(if Student)->50 points
        // Matching What do you Want with Hashtags -> 50 points for each match

    }
}
