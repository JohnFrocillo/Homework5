package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText enterFrom = (EditText) findViewById(R.id.enterFrom);
        EditText enterTo = (EditText) findViewById(R.id.enterTo);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        clear.setOnClickListener(v -> {
            enterFrom.setText(null);
            enterTo.setText(null);

        });

        calculate.setOnClickListener(v -> {
            //Use UnitsConverter class provided to convert units
        });


    }


}
