package com.geektech.servicelesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.servicelesson.service.BasicIntentService;
import com.geektech.servicelesson.service.BasicService;
import com.geektech.servicelesson.service.MediaPlayerService;
import com.geektech.util.Logg;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        BasicService.startMe(this);
        MediaPlayerService.startMe(getApplicationContext());
        BasicIntentService.startMe(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        BasicService.stopMe(this);
        MediaPlayerService.stopMe(getApplicationContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
