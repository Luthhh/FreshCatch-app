package com.example.freshcatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class fishMarket extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProdukAdapter produkAdapter;
    private List<ProdukModels> produkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_market);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        produkList = new ArrayList<>();
        produkAdapter = new ProdukAdapter(produkList, this);
        recyclerView.setAdapter(produkAdapter);

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(fishMarket.this, beranda1.class);
                startActivity(intentHome);
            }
        });

        ImageView fishInfo = findViewById(R.id.fishInfo);
        fishInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFishMarket = new Intent(fishMarket.this, fishInfo.class);
                startActivity(intentFishMarket);
            }
        });

        ImageView imageView14 = findViewById(R.id.fishFarm);
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavigasi = new Intent(fishMarket.this, fishFarm.class);
                startActivity(intentNavigasi);
            }
        });

        ImageView profilImageView = findViewById(R.id.profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to navigate to the profile activity
                Intent intent = new Intent(fishMarket.this, profil.class);
                startActivity(intent);
            }
        });

        fetchDataFromUrl();

    }
    private void fetchDataFromUrl() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-bcdsp/endpoint/getFishMarket";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Parse the JSON response
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                ProdukModels produk = new ProdukModels();
                                produk.setId(jsonObject.getString("_id"));
                                produk.setNama_produk(jsonObject.getString("nama_produk"));
                                produk.setHarga(jsonObject.getInt("harga"));
                                produk.setGambar(jsonObject.getString("gambar"));
                                produk.setDeskripsi(jsonObject.getString("deskripsi"));

                                // Add the ProdukModels object to the list
                                produkList.add(produk);
                            }

                            // Notify the adapter that the data has changed
                            produkAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.e("VolleyError", "Error fetching data: " + error.getMessage());
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }
}