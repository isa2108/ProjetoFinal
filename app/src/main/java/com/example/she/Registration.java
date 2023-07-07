package com.example.she;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration extends AppCompatActivity {
    TextInputLayout e1,e2,e3,e4;
    Button b;
    TextView tv;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        e3 = findViewById(R.id.et3);
        e4 = findViewById(R.id.et4);
        b = findViewById(R.id.b1);
        tv = findViewById(R.id.tv3);
        progressBar = findViewById(R.id.pb);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getEditText().getText().toString().trim();
                String email = e2.getEditText().getText().toString().trim();
                String password = e3.getEditText().getText().toString().trim();
                String confpassword = e4.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    e1.setError("Insira o nome.");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    e2.setError("Insira o email.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    e3.setError("Insira a senha");
                    return;
                }
                if (TextUtils.isEmpty(confpassword)) {
                    e4.setError("insira a senha novamente");
                    return;
                }
                if(password.length() < 6) {
                    e3.setError("Senha deve ter >= 6 caracteres");
                    return;
                }
                if(!(confpassword.equals(password))){
                    e4.getEditText().setText("");
                    e4.setError("Senha incorreta");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registration.this, "Usuário criado.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registration.this, MainActivity.class);
                            intent.putExtra("Name", e1.getEditText().getText().toString());
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(Registration.this, "Erro" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }

        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,login.class));
                finish();
            }
        });


    }
}
