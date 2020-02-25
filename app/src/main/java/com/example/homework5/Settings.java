package com.example.homework5;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Settings extends AppCompatActivity {

    private String selectionFrom = "Yards";
    private String selectionTo = "Meters";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.putExtra("selectionFrom", selectionFrom);
                intent.putExtra("selectionTo", selectionTo);
                startActivity(intent);
                finish();

            }
        });

        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        ArrayAdapter<CharSequence> fromAdapter;

        if (MainActivity.mode.equals("length")) {
            fromAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lengthChoices, android.R.layout.simple_spinner_item);
        }
        else {
            fromAdapter = ArrayAdapter.createFromResource(this,
                    R.array.volumeChoices, android.R.layout.simple_spinner_item);
        }


        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(fromAdapter);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectionFrom = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

        ArrayAdapter<CharSequence> toAdapter;

        if (MainActivity.mode.equals("length")) {
            toAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lengthChoices, android.R.layout.simple_spinner_item);
        }
        else {
            toAdapter = ArrayAdapter.createFromResource(this,
                    R.array.volumeChoices, android.R.layout.simple_spinner_item);
        }

        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        toSpinner.setAdapter(toAdapter);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectionTo = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



    }

}
