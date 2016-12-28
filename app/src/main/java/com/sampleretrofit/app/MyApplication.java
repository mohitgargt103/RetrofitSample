package com.sampleretrofit.app;

import android.app.Application;

import com.sampleretrofit.util.network.RestConfig;

/**
 * Created by mohit on 28/12/16.
 */

public class MyApplication extends Application {


    MyApplication instanse = null;


    @Override
    public void onCreate() {
        super.onCreate();
        instanse = this;

        //Config retrofit
        RestConfig config = new RestConfig();
    }

    public MyApplication getInstance() {
        return instanse;
    }


}
