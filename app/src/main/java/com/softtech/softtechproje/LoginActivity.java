package com.softtech.softtechproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText editMail, editPw;
    private String mailTxt, pwTxt;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editMail = (EditText)findViewById(R.id.userMail);
        editPw = (EditText)findViewById(R.id.userPw);
        mAuth =FirebaseAuth.getInstance();

    }

    public void logIn(View view){
        mailTxt = editMail.getText().toString();
        pwTxt = editPw.getText().toString();

        if(!TextUtils.isEmpty(mailTxt) && !TextUtils.isEmpty(pwTxt)){
            mAuth.signInWithEmailAndPassword(mailTxt, pwTxt)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser(); //giriş başarılıysa çalışacak kısım
                            Intent intent = new Intent(LoginActivity.this,MasterPage.class);
                            startActivity(intent);

                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }else{
            Toast.makeText(this, "Mail veya şifre boş olamaz", Toast.LENGTH_SHORT).show();
        }
    }
    public void toRegister(View view){
        findViewById(R.id.toRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }




}