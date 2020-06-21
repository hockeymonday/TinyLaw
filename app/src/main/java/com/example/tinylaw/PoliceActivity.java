package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PoliceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

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
