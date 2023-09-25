package com.example.lec3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {
    final String TAG = "Concert Dem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        int numTix = 0;
        try{
            Bundle bundle = getIntent().getExtras();
            double costR = bundle.getDouble("COST",0);
            numTix = getIntent().getExtras()
                    .getInt("NUMTIX",0);
            String concertType = bundle.getString("TYPE",
                    "NOTHING");
            DecimalFormat df = new DecimalFormat("$#.00");
            String outputStr = "Concert Type: " + concertType + "\n" +
                    "Num Tix: " + numTix + "\n" +
                    "Total cost: " + df.format(costR);
            TextView txtViewResults = findViewById(R.id.txtViewResults);
            txtViewResults.setText(outputStr);

            txtViewResults.setGravity(Gravity.CENTER);
            txtViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, "Number of tix = " + numTix);
        }
    }
}