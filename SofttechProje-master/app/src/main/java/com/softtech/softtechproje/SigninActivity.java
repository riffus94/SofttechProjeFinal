package com.softtech.softtechproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {

    private EditText mailEdit,pwEdit, pwEditConfirm;
    private String mailtxt, passwordtxt, passwordtxtConfirm;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mailEdit = (EditText)findViewById(R.id.mailRegister);
        pwEdit = (EditText)findViewById(R.id.passwordRegister);
        pwEditConfirm=(EditText)findViewById(R.id.passwordRegisterConfirm);
        mAuth = FirebaseAuth.getInstance();
    }
    public void kayitOl(View view){
        mailtxt = mailEdit.getText().toString();
        passwordtxt = pwEdit.getText().toString();
        passwordtxtConfirm = pwEditConfirm.getText().toString();
        if(!TextUtils.isEmpty(mailtxt) && !TextUtils.isEmpty(passwordtxt)){
            if(passwordtxt.equals(passwordtxtConfirm)) {
                mAuth.createUserWithEmailAndPassword(mailtxt, passwordtxt)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SigninActivity.this, "Kayıt işlemi başarılı", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SigninActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            else{
                Toast.makeText(this, "Şifreleriniz Uyuşmuyor.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Mail veya şifre boş olamaz", Toast.LENGTH_SHORT).show();
        }



    }

    public void alreadyMemberButton(View view){
        findViewById(R.id.alreadyMemberButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}