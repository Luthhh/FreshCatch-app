package com.example.freshcatch;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize TextView
        tvResult = findViewById(R.id.tvresult);
    }

    public void getFishInfo(View view) {
        String urlEndpoint = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-bcdsp/endpoint/getFishInfo";

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlEndpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle the response
                        Log.d("Berita", response);

                        // Display the response in the TextView
                        tvResult.setText(response);

                        // Scroll to the bottom of the ScrollView to show the latest content
                        ScrollView scrollView = findViewById(R.id.scrollView);
                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Log.e("Error", "Error occurred: " + error.getMessage());
                tvResult.setText("Error occurred. Please check logs for details.");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
