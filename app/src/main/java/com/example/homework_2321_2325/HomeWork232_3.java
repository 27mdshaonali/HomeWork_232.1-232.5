package com.example.homework_2321_2325;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework_2321_2325.monetize.AdMob;

public class HomeWork232_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2323);

        // Initialize UI elements
        EditText firstNumber = findViewById(R.id.firstNumber);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView result = findViewById(R.id.result);
        TextView result2 = findViewById(R.id.result2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout containerView = findViewById(R.id.containerView);

        // Set click listener for the button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String inputNumber = firstNumber.getText().toString().trim();

                // Validate the input
                if (inputNumber.isEmpty()) {
                    result.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    firstNumber.setError("Please enter a number.");
                    return;
                }

                try {
                    int n = Integer.parseInt(inputNumber);

                    if (n <= 0 || n > 9) {
                        result.setVisibility(View.GONE);
                        result2.setVisibility(View.GONE);
                        firstNumber.setError("Please enter a number between 1 and 9.");
                        return;
                    }

                    // Initialize series and sum variables
                    long term = 0;
                    long sum = 0;
                    StringBuilder series = new StringBuilder();

                    // Calculate series and sum
                    for (int i = 1; i <= n; i++) {
                        term = term * 10 + n; // Generate the next term
                        series.append(term).append(", "); // Append the term to the series
                        sum += term; // Add the term to the total sum
                    }

                    // Remove the trailing comma and space from the series
                    if (series.length() > 2) {
                        series.setLength(series.length() - 2);
                    }

                    // Display the results
                    result.setVisibility(View.VISIBLE);
                    result.setText("The first " + n + " terms of the series are: " + series);
                    result2.setVisibility(View.VISIBLE);
                    result2.setText("The sum of the series is: " + sum);

                } catch (NumberFormatException e) {
                    firstNumber.setError("Invalid input. Please enter a valid number.");
                }
            }
        });

        AdMob.sdkInitialize(this);
        AdMob.showBannerAd(containerView, this);
    }
}
