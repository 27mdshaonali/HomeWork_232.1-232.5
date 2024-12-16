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

public class HomeWork232_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2325);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText firstNumber = findViewById(R.id.firstNumber);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnCalculate = findViewById(R.id.btnCalculate);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView result = findViewById(R.id.result);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView result2 = findViewById(R.id.result2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout containerView = findViewById(R.id.containerView);

        // Set an onClickListener for the button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String inputWord = firstNumber.getText().toString();

                if (!inputWord.isEmpty()) {

                    // Reverse the word
                    String reversedWord = new StringBuilder(inputWord).reverse().toString();

                    if (inputWord.equals(reversedWord)) {
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered Word is " + inputWord + ". Reversed Word is : " + reversedWord);

                        result2.setText("The word is a palindrome.");
                        result2.setVisibility(View.VISIBLE);
                    } else {

                        // Display the reversed word
                        result.setVisibility(View.VISIBLE);
                        result.setText("Your entered Word is " + inputWord + ". Reversed Word is : " + reversedWord);

                        result2.setVisibility(View.VISIBLE);
                        result2.setText("The word is not a palindrome.");

                    }


                } else {

                    result.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    firstNumber.setError("Please enter a word");

                }


            }
        });


        AdMob.sdkInitialize(this);
        AdMob.showBannerAd(containerView, this);
    }
}