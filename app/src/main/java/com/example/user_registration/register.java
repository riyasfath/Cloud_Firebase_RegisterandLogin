package com.example.user_registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    EditText mail;
    EditText assword;
    Button egister;
    FirebaseAuth auth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mail =findViewById(R.id.email);
        assword =findViewById(R.id.password);
        egister =findViewById(R.id.regbutton);
        auth= FirebaseAuth.getInstance();

        egister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mail.getText().toString().trim();
                String password=assword.getText().toString().trim();


                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(register.this, "Registration success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(register.this,MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(register.this, "Not success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


}