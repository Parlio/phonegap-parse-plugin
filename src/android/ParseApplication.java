package org.apache.cordova.core;

import android.app.Application;
import android.content.Context;

import com.parlio.MainActivity;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;



public class ParseApplication extends Application 
{
    private static ParseApplication instance = new ParseApplication();

    public ParseApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, PARSE_APP_ID, PARSE_CLIENT_KEY);
        PushService.setDefaultPushCallback(this, MainActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
