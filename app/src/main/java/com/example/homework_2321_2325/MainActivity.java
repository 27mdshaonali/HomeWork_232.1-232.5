package com.example.homework_2321_2325;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout hw1, hw2, hw3, hw4, hw5;


    @SuppressLint({"InflateParams", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hw1 = findViewById(R.id.hw1);
        hw2 = findViewById(R.id.hw2);
        hw3 = findViewById(R.id.hw3);
        hw4 = findViewById(R.id.hw4);
        hw5 = findViewById(R.id.hw5);


        hw1.setOnClickListener(this);
        hw2.setOnClickListener(this);
        hw3.setOnClickListener(this);
        hw4.setOnClickListener(this);
        hw5.setOnClickListener(this);


    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.hw1) {
            startActivity(new Intent(this, HomeWork232_1.class));
        }
        if (v.getId() == R.id.hw2) {
            startActivity(new Intent(this, HomeWork232_2.class));
        }
        if (v.getId() == R.id.hw3) {
            startActivity(new Intent(this, HomeWork232_3.class));
        }
        if (v.getId() == R.id.hw4) {
            startActivity(new Intent(this, HomeWork232_4.class));
        }
        if (v.getId() == R.id.hw5) {
            startActivity(new Intent(this, HomeWork232_5.class));
        }

    }
}