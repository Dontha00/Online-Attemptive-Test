package com.example.onlineaptitudetest;


import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Demo extends AppCompatActivity {

    public static final String TAG = "TAG";
    Button btn1,btn2,btn3,btn4;
    TextView tvQuestion,tvTimer;
    int total=1;
    int correct=0;
    int wrong=0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);



        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        tvQuestion = findViewById(R.id.tv_question);
        tvTimer = findViewById(R.id.tv_timer);






        updateQuestion();


    }

    private void updateQuestion()
    {
        total++;
        if (total >4)
        {
            //
        }
        else
        {
            reference = FirebaseDatabase.getInstance().getReference().child("https://online-aptitude-test-501bd.firebaseio.com").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);

                    tvQuestion.setText(question.getQuestion());
                    btn1.setText(question.getOption1());
                    btn2.setText(question.getOption2());
                    btn3.setText(question.getOption3());
                    btn4.setText(question.getOption4());


                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn1.getText().toString().equals(question.getAnswer()))
                            {
                                btn1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                btn1.setBackgroundColor(Color.RED);

                                if (btn2.getText().toString().equals(question.getAnswer()))
                                {
                                    btn2.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn3.getText().toString().equals(question.getAnswer()))
                                {
                                    btn3.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn4.getText().toString().equals(question.getAnswer()))
                                {
                                    btn4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                        }
                    });




                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn2.getText().toString().equals(question.getAnswer()))
                            {
                                btn2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                btn2.setBackgroundColor(Color.RED);

                                if (btn1.getText().toString().equals(question.getAnswer()))
                                {
                                    btn1.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn3.getText().toString().equals(question.getAnswer()))
                                {
                                    btn3.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn4.getText().toString().equals(question.getAnswer()))
                                {
                                    btn4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                        }
                    });




                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn3.getText().toString().equals(question.getAnswer()))
                            {
                                btn3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                btn1.setBackgroundColor(Color.RED);

                                if (btn2.getText().toString().equals(question.getAnswer()))
                                {
                                    btn2.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn1.getText().toString().equals(question.getAnswer()))
                                {
                                    btn1.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn4.getText().toString().equals(question.getAnswer()))
                                {
                                    btn4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                        }
                    });




                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn4.getText().toString().equals(question.getAnswer()))
                            {
                                btn4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else {
                                wrong++;
                                btn1.setBackgroundColor(Color.RED);

                                if (btn2.getText().toString().equals(question.getAnswer()))
                                {
                                    btn2.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn3.getText().toString().equals(question.getAnswer()))
                                {
                                    btn3.setBackgroundColor(Color.GREEN);
                                }
                                else if (btn1.getText().toString().equals(question.getAnswer()))
                                {
                                    btn1.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                        }
                    });




                    Log.d(TAG, "Value is: " + question);





                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "Failed to read value.", databaseError.toException());

                }
            });
        }
    }
}
