package com.example.freshcatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class fishFarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_farm);

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(fishFarm.this, beranda1.class);
                startActivity(intentHome);
            }
        });

        ImageView fishInfo = findViewById(R.id.fishInfo);
        fishInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(fishFarm.this, fishInfo.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView imageView14 = findViewById(R.id.fishMarket);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavigasi = new Intent(fishFarm.this, fishMarket.class);
                startActivity(intentNavigasi);
            }
        });

        ImageView profilImageView = findViewById(R.id.profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate to the profile activity
                Intent intent = new Intent(fishFarm.this, profil.class); // Replace ProfileActivity with the actual name of your profile activity class
                startActivity(intent);
            }
        });
    }
}