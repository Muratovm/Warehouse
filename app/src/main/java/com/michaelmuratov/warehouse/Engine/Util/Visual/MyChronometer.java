package com.michaelmuratov.warehouse.Engine.Util.Visual;

import android.app.Activity;
import android.content.Context;
import android.widget.Chronometer;

public class MyChronometer {
    Chronometer chronometer;

    public MyChronometer(Context context){
        chronometer = new Chronometer(context);
    }

    public MyChronometer(Activity activity, int id){
        chronometer = activity.findViewById(id);
    }

    public void start(){
        chronometer.start();
    }

    public void stop(){
        chronometer.stop();
    }
}
