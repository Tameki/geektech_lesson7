package com.geektech.servicelesson.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.geektech.servicelesson.service.MediaPlayerService;

// Created by askar on 10/26/18.
public class BootReceiver extends BroadcastReceiver {
    //Срабатывает примерно через 1-2 минуты после включения устройства
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayerService.startMe(context.getApplicationContext());
    }
}
