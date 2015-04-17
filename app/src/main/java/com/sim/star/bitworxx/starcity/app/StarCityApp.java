package com.sim.star.bitworxx.starcity.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by WEIS on 17.04.2015.
 */
public class StarCityApp extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        StarCityApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return StarCityApp.context;
    }
}