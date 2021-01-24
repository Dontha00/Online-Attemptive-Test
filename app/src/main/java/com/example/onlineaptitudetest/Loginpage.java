package com.example.onlineaptitudetest;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginpage extends AppCompatActivity {

    EditText etemail , etpassword ;
    TextView text_1;
    Button submit;
    FirebaseAuth fba;
    private FirebaseAuth.AuthStateListener asl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        etemail= (EditText) findViewById(R.id.et_email);
        etpassword= (EditText) findViewById(R.id.et_password);
        submit= (Button) findViewById(R.id.btn_submit);
        text_1= findViewById(R.id.text1);
        fba = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = etemail.getText().toString();
                String Password = etpassword.getText().toString();
                if(Email.isEmpty()){
                    etemail.setError("please enter email");
                    etemail.requestFocus();
                }
                else if (Password.isEmpty()){
                    etpassword.setError("please enter password");
                    etpassword.requestFocus();
                }
                else if (Email.isEmpty() && Password.isEmpty()){
                    Toast.makeText(Loginpage.this, "enter email and password", Toast.LENGTH_SHORT).show();
                }
                else if (!(Email.isEmpty() && Password.isEmpty())) {
                    fba.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(Loginpage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Loginpage.this,"Login Error, please try again",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Intent i =new Intent(Loginpage.this,HomeActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Loginpage.this,"Error!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        text_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loginpage.this, Signup.class);
                Toast.makeText(Loginpage.this, "Signup", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });


        asl = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser fbu = fba.getCurrentUser();
                if (fbu != null) {
                    Toast.makeText(Loginpage.this, "Sucessfully logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Loginpage.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Loginpage.this, "Please Login Here", Toast.LENGTH_SHORT).show();
                }
            }

        };
    }





    @Override
    protected void onStart() {
        super.onStart();
        fba.addAuthStateListener(asl);

    }
}
