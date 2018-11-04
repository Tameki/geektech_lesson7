package com.geektech.util;

import android.util.Log;

// Created by askar on 10/26/18.
public class Logg {
    private static String TAG = "ololo";
    public static Boolean enabled = true;

    public static void d(String message){
        d(TAG, message);
    }

    public static void e(String message, Exception e){
        e(TAG, message, e);
    }

    public static void d(String tag, String message){
        if (enabled) {
            Log.d(tag, message);
        }
    }

    public static void e(String tag, String message, Exception e){
        if (enabled) {
            Log.e(tag, message, e);
        }
    }
}
