package com.michaelmuratov.warehouse.Engine.Util.Visual;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Dimensions {
    public static int height;
    public static int width;

    public Dimensions(Activity activity){
        recordScreenSize(activity);
    }

    private static void recordScreenSize(Activity activity){
        WindowManager manager = (WindowManager) activity.getSystemService(
                Context.WINDOW_SERVICE);
        Display display = manager != null ? manager.getDefaultDisplay() : null;
        Point point = new Point();
        if (display != null) {
            display.getSize(point);
        }
        height = point.y+1000;
        width = point.x;
    }

    public static float[] getCellpoints(float row_begin, float col_begin,float row_end, float col_end){
        float[] coordinates = new float[4];
        coordinates[0] = (1+width/6)*row_begin;                       //x
        coordinates[1] = (1+height/16)*col_begin;                     //y
        coordinates[2] = (1+width/6)*row_end;                         //x+width
        coordinates[3] = (1+height/16)*col_end;                       //y+height
        return coordinates;
    }

    public void height(Activity activity){
        int statusBarHeight = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        // action bar height
        int actionBarHeight;
        final TypedArray styledAttributes = activity.getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize }
        );
        actionBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        // navigation bar height
        int navigationBarHeight = 0;
        resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            Resources resources = activity.getResources();
            navigationBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        Log.d("Status:",""+statusBarHeight);
        Log.d("Action:",""+actionBarHeight);
        Log.d("Navigation:",""+navigationBarHeight);
    }
}
