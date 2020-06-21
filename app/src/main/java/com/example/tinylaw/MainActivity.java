package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.ui);
        emergency = findViewById(R.id.emergency);

        //I have no clue if this is right
        Button emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent emergencyActivityIntent = new Intent(MainActivity.this, emergencyActivity.class);
                //The parameter below is not recognized by the compiler
                startActivity(emergencyActivityIntent);
            }
        });

    }
}
