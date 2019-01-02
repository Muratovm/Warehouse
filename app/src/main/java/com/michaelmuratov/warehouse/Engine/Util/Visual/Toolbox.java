package com.michaelmuratov.warehouse.Engine.Util.Visual;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.michaelmuratov.warehouse.Engine.Listeners.SpinnerListener;
import com.michaelmuratov.warehouse.Engine.Navigation.BottomNavigation;
import com.michaelmuratov.warehouse.Engine.Navigation.Drawer;
import com.michaelmuratov.warehouse.Engine.Screens.ScreenManager;
import com.michaelmuratov.warehouse.Engine.Util.Ads.AdManager;

public class Toolbox{
    public FirebaseAnalytics firebaseAnalytics;
    public Drawer drawer;
    public Toolbar toolbar;
    public BottomNavigation bottomNavigation;
    public MyChronometer chronometer;
    public Activity activity;

    public AdManager adManager;
    ScreenManager screenManager;


    public Toolbox(Activity activity){
        this.activity = activity;
    }

    public static void activiateFullscreen(Activity activity){
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= 17) {
            uiOptions ^= View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            uiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void setupAnalytics(){
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "0");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Toolbox loaded");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);
    }

    public void setupAdvertisements(Activity activity){
        adManager = new AdManager(activity,this);
    }

    public void setup_Spinner(int id, String[] items){
        Spinner dropdown = activity.findViewById(id);
        SpinnerListener listener = new SpinnerListener();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(listener);
    }

}
