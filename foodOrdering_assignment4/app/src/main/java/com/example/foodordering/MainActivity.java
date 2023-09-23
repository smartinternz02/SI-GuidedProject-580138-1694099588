package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pizzaButton = findViewById(R.id.pizzaclick);
        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity when the button is clicked
                navigateToDominosActivity();
            }
        });

        Button kfcButton = findViewById(R.id.kfcclick);
        kfcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity when the button is clicked
                navigateToKFCActivity();
            }
        });

        Button punjabiButton = findViewById(R.id.gujaraticlick);
        punjabiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity when the button is clicked
                navigateToPunjabiActivity();
            }
        });

        Button subwayButton = findViewById(R.id.subwayclick);
        subwayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity when the button is clicked
                navigateToSubwayActivity();
            }
        });

    }

    private void navigateToDominosActivity() {
        Intent intent = new Intent(MainActivity.this, DominosActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToKFCActivity() {
        Intent intent = new Intent(MainActivity.this, KFCActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToPunjabiActivity() {
        Intent intent = new Intent(MainActivity.this, PunjabiActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToSubwayActivity() {
        Intent intent = new Intent(MainActivity.this, SubwayActivity.class);
        startActivity(intent);
        finish();
    }
}