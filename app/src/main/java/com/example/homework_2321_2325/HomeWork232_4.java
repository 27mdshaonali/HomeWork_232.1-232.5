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

public class HomeWork232_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2324);


        EditText firstNumber = findViewById(R.id.firstNumber);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView result = findViewById(R.id.result);
        TextView result2 = findViewById(R.id.result2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout containerView = findViewById(R.id.containerView);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String inputNumber = firstNumber.getText().toString().trim();

                if (!inputNumber.isEmpty()) {

                    try {

                        int num = Integer.parseInt(inputNumber);

                        StringBuilder squareNumbers = new StringBuilder();

                        int sum = 0;

                        for (int i = 1; i <= num; i++) {
                            int square = i * i;
                            squareNumbers.append(square).append(", ");
                            sum += square;

                        }

                        result.setVisibility(View.VISIBLE);
                        result.setText("The first " + num + " square numbers are: " + squareNumbers);
                        result2.setVisibility(View.VISIBLE);
                        result2.setText("The sum of these square numbers is: " + sum);


                    } catch (NumberFormatException e) {
                        firstNumber.setError("Invalid input. Please enter a valid number.");
                    }

                } else {
                    result.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    firstNumber.setError("Please enter a number.");
                }

            }
        });


        AdMob.sdkInitialize(this);
        AdMob.showBannerAd(containerView, this);
    }
}