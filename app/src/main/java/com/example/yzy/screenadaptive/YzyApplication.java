package com.example.yzy.screenadaptive;

import android.app.Application;

/**
 * Created by yzy on 2017/11/29.
 */

public class YzyApplication extends Application {
    private static YzyApplication instance;
    public static YzyApplication getInstance(){
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
