package org.apache.cordova.core;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

import com.parlio.enterprise.CordovaApp;

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
        Parse.initialize(this, "PARSE_APP_ID", "PARSE_CLIENT_KEY");
        PushService.setDefaultPushCallback(this, CordovaApp.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}