package com.example.onlineaptitudetest;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);


        Intent i = getIntent();

        String Questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");

        tv1.setText(Questions);
        tv2.setText(correct);
        tv3.setText(wrong);

    }
}
