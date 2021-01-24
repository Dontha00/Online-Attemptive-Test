package com.example.onlineaptitudetest;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Test extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    TextView tvQuestion, tvTimer;

    int mScore = 0;
    int mQuestionNumber = 0;
    int wrong = 0;
    String mAnswer;
    int msetquestion = 4;

    Firebase mQuestionRef, mchoice1Ref, mchoice2Ref, mchoice3Ref, mchoice4Ref, mAnswerRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        tvQuestion = findViewById(R.id.tv_question);
        tvTimer = findViewById(R.id.tv_timer);

        updateQuestion();
        reverseTimer(30,tvTimer);

        //btn1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.getText().equals(mAnswer)){
                    mScore++;
                    updateQuestion();

                }else {
                    updateQuestion();
                    wrong++;
                }
            }
        });
        //brn1


        //btn2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn2.getText().equals(mAnswer)){
                    mScore++;

                    updateQuestion();

                }else {
                    updateQuestion();
                    wrong++;
                }
            }
        });
        //btn2

        //btn3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3.getText().equals(mAnswer)){
                    mScore++;
                    updateQuestion();
                }else {
                    updateQuestion();
                    wrong++;
                }
            }
        });
        //btn3

        //btn4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn4.getText().equals(mAnswer)){
                    mScore++;

                    updateQuestion();

                }else {
                    updateQuestion();
                    wrong++;
                }
            }
        });
        //brn4





    }

    private void updateScore(int mScore) {
        tvTimer.setText(""+ mScore);
    }

    public void updateQuestion() {

        if (mQuestionNumber > msetquestion)
        {
            Intent i = new Intent(Test.this, Result.class);
            i.putExtra("total",String.valueOf(mQuestionNumber));
            i.putExtra("correct",String.valueOf(mScore));
            i.putExtra("incorrect",String.valueOf(wrong));
            startActivity(i);
        }

        else {

            mQuestionRef = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Questions");
            mQuestionRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String question = dataSnapshot.getValue(String.class);
                    tvQuestion.setText(question);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });

            mchoice1Ref = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Option1");
            mchoice1Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String option = dataSnapshot.getValue(String.class);
                    btn1.setText(option);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });


            mchoice2Ref = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Option2");
            mchoice2Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String option = dataSnapshot.getValue(String.class);
                    btn2.setText(option);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });

            mchoice3Ref = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Option3");
            mchoice3Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String option = dataSnapshot.getValue(String.class);
                    btn3.setText(option);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });

            mchoice4Ref = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Option4");
            mchoice4Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String option = dataSnapshot.getValue(String.class);
                    btn4.setText(option);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                }
            });


            mAnswerRef = new Firebase("https://online-aptitude-test-501bd.firebaseio.com/" + mQuestionNumber + "/Answers");
            mAnswerRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mAnswer = dataSnapshot.getValue(String.class);

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }


        mQuestionNumber++;


    }


    public void reverseTimer(int seconds, final TextView tvTimer)
    {
     CountDownTimer cd_time = new CountDownTimer(seconds* 1000+1000, 1000)
     {
         @Override
         public void onTick(long millisUntilFinished) {
             int seconds = (int) (millisUntilFinished/ 1000);
             int minutes = seconds/60;
             seconds = seconds % 60;
             tvTimer.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
         }


         public void onFinish(){

             if (mQuestionNumber > msetquestion)
             {
                 tvTimer.setText("Submitted");
                 Intent i = new Intent(Test.this, Result.class);
                 i.putExtra("total",String.valueOf(mQuestionNumber));
                 i.putExtra("correct",String.valueOf(mScore));
                 i.putExtra("incorrect",String.valueOf(wrong));
                 startActivity(i);
             }

             else {
                 tvTimer.setText("Time UP");
                 Intent i = new Intent(Test.this, Result.class);
                 i.putExtra("total", String.valueOf(mQuestionNumber));
                 i.putExtra("correct", String.valueOf(mScore));
                 i.putExtra("incorrect", String.valueOf(wrong));
                 startActivity(i);
             }
         }


     }.start();







    }



}
