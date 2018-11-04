package com.geektech.servicelesson.service;

import android.content.Context;
import android.content.Intent;

import com.geektech.core.CoreService;
import com.geektech.util.Logg;

// Created by askar on 10/26/18.
public class BasicService extends CoreService {

    //region Static

    public static void startMe(Context context){
        context.startService(intent(context));
    }

    public static void stopMe(Context context){
        context.stopService(intent(context));
    }

    public static Intent intent(Context context){
        return new Intent(context, BasicService.class);
    }

    //endregion

    @Override
    public void onCreate() {
        Logg.d("Create service");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Logg.d("Destroy service");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logg.d("Start command, thread " + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }
}
