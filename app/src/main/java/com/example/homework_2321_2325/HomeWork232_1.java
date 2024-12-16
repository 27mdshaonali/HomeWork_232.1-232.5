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

public class HomeWork232_1 extends AppCompatActivity {

    EditText firstNumber;
    TextView result;
    Button btnCalculate;
    LinearLayout containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2321);

        firstNumber = findViewById(R.id.firstNumber);
        result = findViewById(R.id.result);
        btnCalculate = findViewById(R.id.btnCalculate);
        containerView = findViewById(R.id.containerView);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String inputNumber = firstNumber.getText().toString().trim();

                if (!inputNumber.isEmpty()) {
                    try {
                        int num = Integer.parseInt(inputNumber);
                        result.setText(""); // Clear previous results

                        // Fix: Generate the table from 1 to 10
                        for (int i = 1; i <= 10; i++) {
                            result.setVisibility(View.VISIBLE);
                            result.append(num + " X " + i + " = " + (num * i) + "\n");
                        }
                    } catch (NumberFormatException e) {
                        result.setText("Invalid input. Please enter a valid number.");
                    }
                } else {
                    // Handle the case when the input field is empty

                    result.setVisibility(View.GONE);
                    firstNumber.setError("Please enter a number");

                }
            }
        });


        AdMob.sdkInitialize(this);
        AdMob.showBannerAd(containerView, this);

    }
}
