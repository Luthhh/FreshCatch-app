package com.example.freshcatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class beranda1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda1);

        ImageView fishInfo = findViewById(R.id.fishInfo);
        fishInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishInfo = new Intent(beranda1.this, fishInfo.class);
                startActivity(intentFishInfo);
            }
        });

        ImageView fishMarket = findViewById(R.id.fishMarket);
        fishMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(beranda1.this, fishMarket.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView imageView14 = findViewById(R.id.fishFarm);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavigasi = new Intent(beranda1.this, fishFarm.class);
                startActivity(intentNavigasi);
            }
        });

        ImageView profilImageView = findViewById(R.id.profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate to the profile activity
                Intent intent = new Intent(beranda1.this, profil.class); // Replace ProfileActivity with the actual name of your profile activity class
                startActivity(intent);
            }
        });


        View view7 = findViewById(R.id.view7);
        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(beranda1.this, fishInfo.class);
                startActivity(intent);
            }
        });

        View view5 = findViewById(R.id.view5);
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(beranda1.this, fishFarm.class);
                startActivity(intent);
            }
        });

        View view8 = findViewById(R.id.view8);
        view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(beranda1.this, fishMarket.class);
                startActivity(intent);
            }
        });

        View fishBot = findViewById(R.id.fishBot);
        fishBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk berpindah ke halaman ChatbotPage
                Intent intent = new Intent(beranda1.this, ChatbotPage.class); // Ganti dengan kelas ChatbotPage yang sesuai
                startActivity(intent);
            }
        });
    }
}
