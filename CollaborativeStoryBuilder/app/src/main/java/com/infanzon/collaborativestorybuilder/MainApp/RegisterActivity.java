package com.infanzon.collaborativestorybuilder.MainApp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.infanzon.collaborativestorybuilder.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText RegisterEmail, RegisterPassword, ConfirmPassword;
    private Button btnRegister;
    private TextView LoginRedirect;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        RegisterEmail = findViewById(R.id.RegisterEmail);
        RegisterPassword = findViewById(R.id.RegisterPassword);
        ConfirmPassword = findViewById(R.id.ConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        LoginRedirect = findViewById(R.id.LoginRedirect);

        btnRegister.setOnClickListener(v -> registerUser());
        LoginRedirect.setOnClickListener(v -> {
            // Navigate to Login Activity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void registerUser() {
        String email = RegisterEmail.getText().toString().trim();
        String password = RegisterPassword.getText().toString().trim();
        String confirmPassword = ConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            RegisterEmail.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            RegisterPassword.setError("Password is required");
            return;
        }

        if (password.length() < 6) {
            RegisterPassword.setError("Password must be at least 6 characters");
            return;
        }

        if (!password.equals(confirmPassword)) {
            ConfirmPassword.setError("Passwords do not match");
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                        // Navigate to Login or Main Activity
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
