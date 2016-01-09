package com.example.milind.mapplication3;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by milind on 11/12/15.
 */
public class Splash extends Activity {
  //  MediaPlayer msong = MediaPlayer.create(Splash.this,R.raw.msong);
    @Override
    protected void onCreate(Bundle itsSplash) {
        super.onCreate(itsSplash);
        setContentView(R.layout.splash);
       // msong.start();
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingpoint = new Intent("com.example.milind.mapplication3.MAINACTIVITY");
                    startActivity(openStartingpoint);

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
       // msong.release();
        finish();
    }
}
