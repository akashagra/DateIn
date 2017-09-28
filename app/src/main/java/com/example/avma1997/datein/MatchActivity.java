package com.example.avma1997.datein;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        FirebaseDatabase mFirebaseData=FirebaseDatabase.getInstance();
        FirebaseAuth mAuth;
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        DatabaseReference mDatabaseReference=mFirebaseData.getReference();
        Log.i("DataArrha",currentUser.getEmail());

        User newUser=new User(currentUser.getUid(),currentUser.getDisplayName(),currentUser.getEmail());
        mDatabaseReference.child("user_details").child("user").child(currentUser.getUid()).setValue(newUser);

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
