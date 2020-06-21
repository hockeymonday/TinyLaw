package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SetupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] languages = {"English", "Spanish", "Chinese", "Arabic", "Korean", "French"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        spinner = findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(this);

        List<String> languages = new ArrayList<String>();
        languages.add("English");
        languages.add("Español");
        languages.add("Français");
        languages.add("العربية");
        languages.add("普通话");
        languages.add("한국인");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,languages);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Selected: "+item,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("language",item);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}