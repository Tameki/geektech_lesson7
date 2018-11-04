package com.geektech.servicelesson.service;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;

import com.geektech.core.CoreService;
import com.geektech.servicelesson.R;
import com.geektech.util.Logg;

// Created by askar on 10/26/18.
public class MediaPlayerService extends CoreService {
    //region Static
    public static String START_MEDIA_NAME = "start_media_name";
    public static String START_PLAY = "start_play";
    public static String STOP_PLAY = "stop_play";

    public static void startMe(Context context){
        context.startService(intent(context));
    }

    public static void stopMe(Context context){
        context.stopService(intent(context));
    }

    public static Intent intent(Context context){
        return new Intent(context, MediaPlayerService.class);
    }

    //endregion

    private MediaPlayer mPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(this, R.raw.chopin);
        mPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logg.d("Start Media service");

        if (mPlayer != null) {
            if (mPlayer.isPlaying()){
                Logg.d("Player is already started");
            } else {
                mPlayer.start();
            }
        }

        delayedStop();

        return super.onStartCommand(intent, flags, startId);
    }

    private void delayedStop(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Logg.d("Stop Media service");
                MediaPlayerService.this.stopSelf();
            }
        }, 10000);
    }

    @Override
    public void onDestroy() {
        Logg.d("Destroy media service");

        if (mPlayer != null) {
            mPlayer.stop();
        }

        super.onDestroy();
    }
}
