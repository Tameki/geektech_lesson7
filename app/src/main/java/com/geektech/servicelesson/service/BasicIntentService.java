package com.geektech.servicelesson.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.geektech.util.Logg;

// Created by askar on 10/26/18.
public class BasicIntentService extends IntentService {

    //region Static

    public static void startMe(Context context){
        context.startService(intent(context));
    }

    public static void stopMe(Context context){
        context.stopService(intent(context));
    }

    public static Intent intent(Context context){
        return new Intent(context, BasicIntentService.class);
    }

    //endregion

    public BasicIntentService(){
        super("BasicIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Logg.d("Intent service thread " + Thread.currentThread().getName());
    }

    @Override
    public void onDestroy() {
        Logg.d("Destroy intent service");
        super.onDestroy();
    }
}
