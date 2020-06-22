package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
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
        Typeface face4;
        face4 = Typeface.createFromAsset(getAssets(),"ac9.otf");
        policeButton1.setTypeface(face4);
        policeButton2 = findViewById(R.id.policeButton2);
        Typeface face3;
        face3 = Typeface.createFromAsset(getAssets(),"ac9.otf");
        policeButton2.setTypeface(face3);
        policeButton3 = findViewById(R.id.policeButton3);
        Typeface face2;
        face2 = Typeface.createFromAsset(getAssets(),"ac9.otf");
        policeButton3.setTypeface(face2);
        policeButton4 = findViewById(R.id.policeButton4);
        Typeface face1;
        face1 = Typeface.createFromAsset(getAssets(),"ac9.otf");
        policeButton4.setTypeface(face1);
        policeButton5 = findViewById(R.id.policeButton5);
        Typeface face;
        face = Typeface.createFromAsset(getAssets(),"ac9.otf");
        policeButton5.setTypeface(face);
        // Get the string as an array list
        Intent intent = getIntent();
        String jsonArray = intent.getStringExtra("police");
        try {
            JSONArray array = new JSONArray(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        policeButton1.setText("Pulled Over?");
        policeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SmallActivity.class);
                startActivity(intent);
            }
        });
        policeButton2.setText("Detained in Public?");
        policeButton3.setText("Arrested?");
        policeButton4.setText("Rights Violated?");
        policeButton5.setText("Police At Your House?");



    }
}
