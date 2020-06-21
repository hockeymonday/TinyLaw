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
}
