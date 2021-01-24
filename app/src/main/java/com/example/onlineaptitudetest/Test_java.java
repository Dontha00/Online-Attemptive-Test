package com.example.onlineaptitudetest;

import android.app.Application;

import com.firebase.client.Firebase;

public class Test_java extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
