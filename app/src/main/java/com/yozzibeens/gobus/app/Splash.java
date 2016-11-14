package com.yozzibeens.gobus.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yozzibeens.gobus.R;

/**
 * Created by Antonio on 11/11/2016.
 */

public class Splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        /*RivosPartnerDB.initializeInstance();
        GoogleCloudMessaging.getInstance(this);*/

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);

                }
            }
        };
        timerThread.start();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
