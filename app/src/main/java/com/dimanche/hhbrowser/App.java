package com.dimanche.hhbrowser;

import android.app.Application;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/323:13
 * desc   :
 * version: 1.0
 */
public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
