package com.michaelmuratov.warehouse.Engine.UI;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.TextView;

public class TextFactory {
    public TextFactory(){

    }

    public static TextView makeText(Activity activity, String message, int size){
        TextView tv = new TextView(activity.getBaseContext());
        tv.setText(message);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        tv.setTextColor(Color.BLACK);
        return tv;
    }
}
