package com.michaelmuratov.warehouse.Engine.Util.Code;

import android.util.Log;

public class Logger {

    public static boolean Logging = true;

    public static void newLog(String tag, String message){
        if(Logging){
            Log.d(tag,message);
        }
    }
}
