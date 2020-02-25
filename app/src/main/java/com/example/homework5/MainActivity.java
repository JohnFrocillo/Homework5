package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mode = "Length";

        EditText enterFrom = (EditText) findViewById(R.id.enterFrom);
        EditText enterTo = (EditText) findViewById(R.id.enterTo);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        TextView fromUnits = (TextView) findViewById(R.id.fromUnits);
        TextView toUnits = (TextView) findViewById(R.id.toUnits);

        clear.setOnClickListener(v -> {
            enterFrom.setText(null);
            enterTo.setText(null);

        });

        calculate.setOnClickListener(v -> {
            //Use UnitsConverter class provided to convert units

            if (!enterFrom.getText().toString().isEmpty() && !enterTo.getText().toString().isEmpty()) {
                enterFrom.setError("Only 1 field can be filled at a time!");
                return;
            }

            double from;
            double to;
            double lenVal = 0.0;

            if (mode.equals("Length")) {
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
            else if (mode.equals("Volume")) {

            }


        });


    }


}
