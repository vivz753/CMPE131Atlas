package com.example.x1user.atlas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth fba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);

        final Button bLogin = (Button)findViewById(R.id.bLogin);

        fba = FirebaseAuth.getInstance();

        bLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                verifyAccount();

            }
        });


        final TextView tvRegister = (TextView)findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    private void verifyAccount(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();


        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter valid e-mail and password", Toast.LENGTH_SHORT).show();
            return;
        }

        fba.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent iLogin = new Intent(LoginActivity.this, UserAreaActivity.class);
                    startActivity(iLogin);

                } else

                {
                    Toast.makeText(LoginActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
