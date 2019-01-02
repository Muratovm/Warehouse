package com.michaelmuratov.warehouse.Engine.Application;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Class in charge of locking the Home Screen
 */
public class LockController {

    /**
     * Sets the preferred Home launcher if the "next" Class is a category.HOME
     * @param context Activity context
     * @param current   Current class
     * @param next      Class to set as home
     */
    public static void setPreferredHomeActivity(Context context, Class current, Class next){
        PackageManager p = context.getPackageManager();

        //sets the next class as the foreground
        ComponentName nextCN = new ComponentName(context, next);
        p.setComponentEnabledSetting(nextCN, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        //sets the previous class as the background
        ComponentName prevCN = new ComponentName(context, current);
        p.setComponentEnabledSetting(prevCN, PackageManager.COMPONENT_ENABLED_STATE_DEFAULT, PackageManager.DONT_KILL_APP);

        //Creates the intent of the next class
        Intent intent = new Intent(context, next);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        try {
            pendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }

        //Starts that intent
        context.startActivity(intent);

    }

    /**
     * Calls the home button to trigger
     * @param context Activity context
     */
    public static void callHome(Context context){
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
