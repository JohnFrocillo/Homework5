package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final int SELECTION = 1;
    public static String mode = "length";
    private String title = "Length Converter";

    private String changeMode() {
        if (mode.equals("length")) {
            mode = "volume";
            title = "Volume Converter";
        }
        else {
            mode = "length";
            title = "Length Converter";
        }

        return mode;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText enterFrom = (EditText) findViewById(R.id.enterFrom);
        EditText enterTo = (EditText) findViewById(R.id.enterTo);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);
        Button mode = (Button) findViewById(R.id.modeButton);

        TextView fromUnits = (TextView) findViewById(R.id.fromUnits);
        TextView toUnits = (TextView) findViewById(R.id.toUnits);
        TextView conversionTitle = (TextView) findViewById(R.id.conversionTitle);

        setTitle("Conversion Calc");



        mode.setOnClickListener(v -> {
            String temp = changeMode();
            if (temp.equals("length")) {
                fromUnits.setText("Yards");
                toUnits.setText("Meters");
                conversionTitle.setText(title);
            }
            else {
                fromUnits.setText("Liters");
                toUnits.setText("Quarts");
                conversionTitle.setText(title);
            }
        });


        clear.setOnClickListener(v -> {
            enterFrom.setText(null);
            enterTo.setText(null);

        });


        Intent payload = getIntent();
        if (payload.hasExtra("selectionFrom") && payload.hasExtra("selectionTo")) {
            String selectionFrom = payload.getStringExtra("selectionFrom");
            fromUnits.setText(selectionFrom);
            String selectionTo = payload.getStringExtra("selectionTo");
            toUnits.setText(selectionTo);

            if(toUnits.getText().equals("Quarts") || toUnits.getText().equals("Liters") ||
                    toUnits.getText().equals("Gallons")) {
                conversionTitle.setText("Volume Converter");
            }
            else {
                conversionTitle.setText("Length Converter");
            }
        }



        calculate.setOnClickListener(v -> {
            //Use UnitsConverter class provided to convert units

            if (!enterFrom.getText().toString().isEmpty() && !enterTo.getText().toString().isEmpty()) {
                enterFrom.setError("Only 1 field can be filled at a time!");
                return;
            }

            double from;
            double to;
            double lenVal = 0.0;

            if (this.mode.equals("length")) {
                if(!enterFrom.getText().toString().isEmpty()) {
                    //if the fromText is NOT empty, then you need to fill the enterTo
                    to = Double.parseDouble(enterFrom.getText().toString());

                    //check the label for what the from unit is
                    UnitsConverter.LengthUnits newFrom = UnitsConverter.LengthUnits.valueOf
                            (fromUnits.getText().toString());

                    //check the label for what the to unit is
                    UnitsConverter.LengthUnits newTo = UnitsConverter.LengthUnits.valueOf
                            (toUnits.getText().toString());

                    lenVal = UnitsConverter.convert(to, newFrom, newTo);

                    enterTo.setText(Double.toString(lenVal));
                }
                else if (!enterTo.getText().toString().isEmpty()) {
                    //if the toText is NOT empty, then you need to fill the enterFrom
                    from = Double.parseDouble(enterTo.getText().toString());

                    //check the label for what the from unit is
                    UnitsConverter.LengthUnits newFrom = UnitsConverter.LengthUnits.valueOf
                            (fromUnits.getText().toString());

                    //check the label for what the to unit is
                    UnitsConverter.LengthUnits newTo = UnitsConverter.LengthUnits.valueOf
                            (toUnits.getText().toString());

                    lenVal = UnitsConverter.convert(from, newTo, newFrom);

                    enterFrom.setText(Double.toString(lenVal));

                }
            }
            else if (this.mode.equals("volume")) {
                if(!enterFrom.getText().toString().isEmpty()) {
                    //if the fromText is NOT empty, then you need to fill the enterTo
                    to = Double.parseDouble(enterFrom.getText().toString());

                    //check the label for what the from unit is
                    UnitsConverter.VolumeUnits newFrom = UnitsConverter.VolumeUnits.valueOf
                            (fromUnits.getText().toString());

                    //check the label for what the to unit is
                    UnitsConverter.VolumeUnits newTo = UnitsConverter.VolumeUnits.valueOf
                            (toUnits.getText().toString());

                    lenVal = UnitsConverter.convert(to, newFrom, newTo);

                    enterTo.setText(Double.toString(lenVal));
                }
                else if (!enterTo.getText().toString().isEmpty()) {
                    //if the toText is NOT empty, then you need to fill the enterFrom
                    from = Double.parseDouble(enterTo.getText().toString());

                    //check the label for what the from unit is
                    UnitsConverter.VolumeUnits newFrom = UnitsConverter.VolumeUnits.valueOf
                            (fromUnits.getText().toString());

                    //check the label for what the to unit is
                    UnitsConverter.VolumeUnits newTo = UnitsConverter.VolumeUnits.valueOf
                            (toUnits.getText().toString());

                    lenVal = UnitsConverter.convert(from, newTo, newFrom);

                    enterFrom.setText(Double.toString(lenVal));

                }
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.goToSettings) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
            return true;
        }
        return false;
    }


}
