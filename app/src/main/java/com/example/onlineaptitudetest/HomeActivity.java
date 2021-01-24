package com.example.onlineaptitudetest;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    LinearLayout profilehome, testhome, resulthome, demohome;
    FirebaseAuth fba;
    private FirebaseAuth.AuthStateListener asl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profilehome = findViewById(R.id.llprofile);
        testhome = findViewById(R.id.lltest);
        resulthome = findViewById(R.id.llresult);
        demohome = findViewById(R.id.lldemo);

        profilehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Profile.class);
                Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        testhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Test.class);
                Toast.makeText(HomeActivity.this, "Test", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        resulthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Result.class);
                Toast.makeText(HomeActivity.this, "Result", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        demohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Demo.class);
                Toast.makeText(HomeActivity.this, "Demo", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i1log:
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        alertDialogBuilder.setTitle("Confirm Exit");

        alertDialogBuilder.setMessage("Are you sure you want to exit");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(HomeActivity.this, "You Click On Cancel", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



}