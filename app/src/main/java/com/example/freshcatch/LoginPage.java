package com.example.freshcatch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {
    private Button loginBtn;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginBtn = findViewById(R.id.loginBtn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String urlEndPoints = "https://ap-southeast-1.aws.data.mongodb-api.com/app/application-0-bcdsp/endpoint/getUserByEmailAndPassword?email=" + email.getText().toString() + "&password=" + password.getText().toString();

        StringRequest sr = new StringRequest(
                Request.Method.GET,
                urlEndPoints,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("LoginPage", "Raw Server Response: " + response);

                        try {
                            JSONObject userJson = new JSONObject(response);

                            String username = userJson.getString("nama");
                            String email = userJson.getString("email");
                            String notelp = userJson.getString("notlp");
                            String role = userJson.getString("role");

                            // Store user data in SharedPreferences
                            SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", username);
                            editor.putString("email", email);
                            editor.putString("notelp", notelp);
                            editor.putString("role", role);
                            editor.apply();

                            Toast.makeText(LoginPage.this, "Login successful!", Toast.LENGTH_SHORT).show();

                            // Redirect based on the user's role
                            if ("admin".equals(role)) {
                                Intent adminIntent = new Intent(LoginPage.this, beranda1.class);
                                startActivity(adminIntent);
                            } else {
                                Intent userIntent = new Intent(LoginPage.this, beranda1.class);
                                startActivity(userIntent);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(LoginPage.this, "Login Unsuccessful!", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LoginPage", "Volley Error: " + error.getMessage());
                        Toast.makeText(LoginPage.this, "Login Unsuccessful!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(sr);
    }
}
