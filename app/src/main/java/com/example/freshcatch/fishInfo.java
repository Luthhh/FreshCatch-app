package com.example.freshcatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class fishInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_info);

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(fishInfo.this, beranda1.class);
                startActivity(intentHome);
            }
        });

        ImageView fishMarket = findViewById(R.id.fishMarket);
        fishMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(fishInfo.this, fishMarket.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView imageView14 = findViewById(R.id.fishFarm);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavigasi = new Intent(fishInfo.this, fishFarm.class);
                startActivity(intentNavigasi);
            }
        });

        ImageView profilImageView = findViewById(R.id.profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate to the profile activity
                Intent intent = new Intent(fishInfo.this, profil.class); // Replace ProfileActivity with the actual name of your profile activity class
                startActivity(intent);
            }
        });
    }
}
