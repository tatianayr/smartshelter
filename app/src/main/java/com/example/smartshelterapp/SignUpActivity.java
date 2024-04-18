package com.example.smartshelterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smartshelterapp.databinding.ActivityLoginBinding;
import com.example.smartshelterapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    String firstName, lastName, age, userName, password;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstName = binding.firstName.getText().toString();
                lastName = binding.lastName.getText().toString();
                age = binding.age.getText().toString();
                userName = binding.userName.getText().toString();
                password = binding.password.getText().toString();

                if (!firstName.isEmpty() && !lastName.isEmpty() && !age.isEmpty() && !userName.isEmpty() && !password.isEmpty()) {

                    String hashedPassword = PasswordHasher.hashPassword(password);

                    if (hashedPassword != null) {
                        Users users = new Users(firstName, lastName, age, userName, password);
                        db = FirebaseDatabase.getInstance();
                        reference = db.getReference("Users");
                        reference.child(userName).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                    startActivity(intent);

                                    binding.firstName.setText("");
                                    binding.lastName.setText("");
                                    binding.age.setText("");
                                    binding.userName.setText("");
                                    binding.password.setText("");
                                    Toast.makeText(SignUpActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Failed to update", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(SignUpActivity.this, "Failed to hash password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
