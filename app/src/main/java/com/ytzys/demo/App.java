package com.ytzys.demo;


import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/15.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("App", "onCreate");
    }
}
