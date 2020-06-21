package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button emergency;
    SearchView searchView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    JSONArray infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        imageView = findViewById(R.id.ui);
        emergency = findViewById(R.id.emergency);
        searchView = findViewById(R.id.search_bar);
        searchView.setQueryHint("Search for a Right");
        // Stop Auto Search on Launch
        searchView.setFocusable(false);
        searchView.setIconified(false);
        searchView.clearFocus();

        Intent intent = getIntent();
        String language = intent.getStringExtra("language");
        final String contactName = intent.getStringExtra("name");
        final String contactPhone = intent.getStringExtra("number");

        //Emergency button activation
        Button emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent emergencyActivityIntent = new Intent(MainActivity.this, EmergencyActivity.class);
                emergencyActivityIntent.putExtra("name",contactName);
                emergencyActivityIntent.putExtra("number",contactPhone);
                startActivity(emergencyActivityIntent);
            }
        });

        // Run Setup Activity on First App Open
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(MainActivity.this, SetupActivity.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();


        // JSON parsing
        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset(language));
            JSONObject info = jsonObject.getJSONObject("info");
            infoList = info.getJSONArray("categories");


            //collect name of each category
            final ArrayList<String> categoryNames = new ArrayList<String>();
            for(int i=0; i<infoList.length(); i++) {
                String categoryName = infoList.getJSONObject(i).getString("name");
                categoryNames.add(categoryName);
                // Assign text to each button
                if (i==0){
                    button1.setText(categoryName);
                    Typeface face;
                    face = Typeface.createFromAsset(getAssets(),"ac9.otf");
                    button1.setTypeface(face);
                } else if (i==1){
                    button2.setText(categoryName);
                    Typeface face;
                    face = Typeface.createFromAsset(getAssets(),"ac9.otf");
                    button2.setTypeface(face);
                } else if (i==2){
                    button3.setText(categoryName);
                    Typeface face;
                    face = Typeface.createFromAsset(getAssets(),"ac9.otf");
                    button3.setTypeface(face);
                } else if (i==3){
                    button4.setText(categoryName);
                    Typeface face;
                    face = Typeface.createFromAsset(getAssets(),"ac9.otf");
                    button4.setTypeface(face);
                } else if (i==4){
                    button5.setText(categoryName);
                    Typeface face;
                    face = Typeface.createFromAsset(getAssets(),"ac9.otf");
                    button5.setTypeface(face);
                }
            }
        } catch(JSONException e){
            e.printStackTrace();
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent policeIntent = new Intent(MainActivity.this, PoliceActivity.class);
                try {
                    policeIntent.putExtra("police", infoList.get(0).toString());
                    startActivity(policeIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //Call JSON
    public String loadJSONFromAsset(String language) {

        // Select the right language JSON
        String selected = "englishLaws.json";
        if (language=="English") {
            selected = "englishLaws.json";
        } else if(language=="Español") {
            selected = "spanishLaws.json";
        } else if(language=="Français") {
            selected = "frenchLaws.json";
        } else if(language=="العربية") {
            selected = "arabicLaws.json";
        } else if(language=="普通话") {
            selected = "chineseLaws.json";
        } else if(language=="한국인") {
            selected = "koreanLaws.json";
        }

        String json = null;
        try{
            InputStream is = getAssets().open(selected);
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

}
