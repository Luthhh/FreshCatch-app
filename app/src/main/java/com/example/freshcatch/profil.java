package com.example.freshcatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(profil.this, beranda1.class);
                startActivity(intentHome);
            }
        });

        ImageView fishInfo = findViewById(R.id.fishInfo);
        fishInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(profil.this, fishInfo.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView fishMarket = findViewById(R.id.fishMarket);
        fishMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(profil.this, fishMarket.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView imageView14 = findViewById(R.id.fishFarm);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavigasi = new Intent(profil.this, fishFarm.class);
                startActivity(intentNavigasi);
            }
        });
    }
}