package com.geektech.servicelesson;

import android.app.Application;
import android.util.Log;

import com.geektech.util.Logg;

// Created by askar on 10/26/18.
public class ServiceApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ololo", "Application create");

        Logg.enabled = BuildConfig.DEBUG;
    }
}
