package com.michaelmuratov.warehouse.Engine.Application;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.michaelmuratov.warehouse.R;


public class Load {

    private Activity activity;

    public Load(Activity activity){
        this.activity = activity;
    }

    public String loadName(){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(activity.getString(R.string.app_name),"not this");
    }
}
