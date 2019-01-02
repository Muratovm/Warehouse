package com.michaelmuratov.warehouse.Engine.Application;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.michaelmuratov.warehouse.R;

public class Save {

    private SharedPreferences sharedPref;
    private Activity activity;

    public Save(Activity activity){
        sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        this.activity = activity;
    }

    public void saveString(String name){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(activity.getString(R.string.app_name), name);
        editor.apply();
    }
}
