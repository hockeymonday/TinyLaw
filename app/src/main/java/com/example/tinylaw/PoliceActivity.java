package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PoliceActivity extends AppCompatActivity {
    ImageView imageView;
    Button policeButton1;
    Button policeButton2;
    Button policeButton3;
    Button policeButton4;
    Button policeButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        policeButton1 = findViewById(R.id.policeButton1);
        policeButton2 = findViewById(R.id.policeButton2);
        policeButton3 = findViewById(R.id.policeButton3);
        policeButton4 = findViewById(R.id.policeButton4);
        policeButton5 = findViewById(R.id.policeButton5);
        imageView = findViewById(R.id.ui);
        // Get the string as an array list
        Intent intent = getIntent();
        String jsonArray = intent.getStringExtra("police");
        try {
            JSONArray array = new JSONArray(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
