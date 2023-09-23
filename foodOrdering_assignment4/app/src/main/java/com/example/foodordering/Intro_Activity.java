package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button signInButton = findViewById(R.id.introbutton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLoginActivity();
            }
        });

    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(Intro_Activity.this, login_Activity.class);
        startActivity(intent);
        finish();
    }

}