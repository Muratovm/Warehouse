package com.michaelmuratov.warehouse.Engine.UI.Cards;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.michaelmuratov.warehouse.Engine.Util.Code.Metrics;

public class ReminderCard extends Card {
    public static int numReminders;
    int margin;
    Activity activity;
    public String title;
    public String note;
    public String date;
    public String time;

    public ReminderCard(Activity activity){
        super(activity);
        this.activity = activity;
        margin = Metrics.convertDpToPixel(activity.getBaseContext(),5);
    }

    public void makeCard(String[] messages) {
        title = messages[0];
        note = messages[1];
        date = messages[2];
        time = messages[3];
        numReminders++;
        numCards++;
    }

    @Override
    public void onFocusListener() {
        super.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean isFocus){
                if (isFocus){
                    Log.d("CARD","FOCUSED");
                }
            }
        });
    }

    @Override
    public void onClickListener() {
        super.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("CARD","CLICKED");
            }
        });
    }
}
