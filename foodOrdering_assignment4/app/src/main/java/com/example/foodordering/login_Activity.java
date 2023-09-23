package com.example.foodordering;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signInButton = findViewById(R.id.login);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity when the button is clicked
                navigateToMainActivity();
            }
        });
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(login_Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
