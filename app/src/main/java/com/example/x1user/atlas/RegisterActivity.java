package com.example.x1user.atlas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth fba;

    private EditText etEmail;
    private EditText etPassword;
    private EditText etNickName;
    private EditText etPhoneNumber;

    private User theUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fba = FirebaseAuth.getInstance();

        etEmail = (EditText)findViewById(R.id.etEmail);
         etPassword = (EditText)findViewById(R.id.etPassword);
        etNickName = (EditText)findViewById(R.id.etNickName);
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);

        final Button bRegister = (Button)findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createAccount();

            }
        });
    }

    private void createAccount(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String nickname = etNickName.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();

        //theUser = new User(email, password, nickname, phoneNumber);

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter valid e-mail and password", Toast.LENGTH_SHORT).show();
            return;
        }

        fba.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent iRegister = new Intent(RegisterActivity.this, UserAreaActivity.class);
                    startActivity(iRegister);

                } else

                {
                    Toast.makeText(RegisterActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}

