package com.example.homework_2321_2325;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework_2321_2325.monetize.AdMob;

public class HomeWork232_2 extends AppCompatActivity {

    EditText firstNumber;
    TextView result, result2;
    Button btnCalculate;
    LinearLayout containerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work2322);

        firstNumber = findViewById(R.id.firstNumber);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);
        btnCalculate = findViewById(R.id.btnCalculate);
        containerView = findViewById(R.id.containerView);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String inputNumber = firstNumber.getText().toString().trim();

                if (!inputNumber.isEmpty()) {
                    try {
                        int n = Integer.parseInt(inputNumber);
                        StringBuilder evenNumbers = new StringBuilder();
                        int sum = 0;

                        // Generate n terms of even numbers and their sum
                        for (int i = 1; i <= n; i++) {
                            int evenNumber = 2 * i; // Generate the ith even number
                            evenNumbers.append(evenNumber).append(", "); // Append to result
                            sum += evenNumber; // Add to sum
                        }

                        // Display results
                        result.setVisibility(View.VISIBLE);
                        result.setText("The first " + n + " even numbers are: " + evenNumbers);
                        result2.setVisibility(View.VISIBLE);
                        result2.setText("The sum of these even numbers is: " + sum);

                    } catch (NumberFormatException e) {
                        result.setText("Invalid input. Please enter a valid number.");
                    }
                } else {
                    result.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    // Handle the case when the input field is empty
                    firstNumber.setError("Please enter a number");
                }
            }
        });

        AdMob.sdkInitialize(this);
        AdMob.showBannerAd(containerView, this);
    }
}
