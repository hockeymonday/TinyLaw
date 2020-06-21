package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button emergency;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.ui);
        emergency = findViewById(R.id.emergency);
        searchView = findViewById(R.id.search_bar);
        searchView.setQueryHint("Search for a Right");

        //Emergency button activation
        Button emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent emergencyActivityIntent = new Intent(MainActivity.this, EmergencyActivity.class);
                startActivity(emergencyActivityIntent);
            }
        });


        // Run Setup Activity on First App Open
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(MainActivity.this, SetupActivity.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

    }

//Call English JSON
    public String loadJSONFromAsset() {
        String json = null;
        try{
            InputStream is = getAssets().open("englishLaws.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    try{
        JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
        JSONObject info = jsonObject.getJSONObject("info");
        JSONArray infoList = info.getJSONArray("categories");


        //collect name of each category
        final String[] categoryNames = new String[0];
        for(int i=0; i<infoList.length(); i++) {
            String categoryName = infoList.getJSONObject(i).getString("name");
            categoryNames[i] = categoryName;
        }
    }
    catch{
        //insert catchh
    }
}
