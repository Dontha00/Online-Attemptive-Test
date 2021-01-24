package com.example.onlineaptitudetest;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnlog , btnsignup ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlog=findViewById(R.id.btnlogin);
        btnsignup=findViewById(R.id.btnsignup);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent( MainActivity.this,Loginpage.class);
                Toast.makeText(MainActivity.this,"Login",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Signup.class);
                Toast.makeText(MainActivity.this,"Signup",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

    }
}
