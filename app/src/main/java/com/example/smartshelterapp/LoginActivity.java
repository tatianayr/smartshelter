package com.example.smartshelterapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartshelterapp.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    String userName, password;
    FirebaseDatabase database;
    DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar Firebase Database
        database = FirebaseDatabase.getInstance();
        // Referência aos usuários no banco de dados
        usersRef = database.getReference("Users");

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter o nome de usuário e a senha inseridos pelo usuário
                userName = binding.userName.getText().toString();
                password = binding.password.getText().toString();

                // Verificar se os campos estão preenchidos
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Autenticar o usuário
                authenticateUser(userName, password);
            }
        });
    }

    private void authenticateUser(final String userName, final String password) {
        // Adicionar um listener para recuperar os dados do usuário
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Verificar se o usuário existe e se a senha está correta
                if (dataSnapshot.child(userName).exists()) {
                    Users user = dataSnapshot.child(userName).getValue(Users.class);
                    if (user != null && user.getPassword().equals(password)) {
                        // Login bem-sucedido
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MapsActivity.class));

                        // Faça o que você precisa aqui, como navegar para outra tela
                    } else {
                        // Senha incorreta
                        Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Usuário não encontrado
                    Toast.makeText(LoginActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Tratamento de erro
                Toast.makeText(LoginActivity.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
