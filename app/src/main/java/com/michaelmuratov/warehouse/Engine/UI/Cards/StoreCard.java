package com.michaelmuratov.warehouse.Engine.UI.Cards;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.michaelmuratov.warehouse.Engine.Util.Code.Metrics;


@SuppressLint("ViewConstructor")
public class StoreCard extends Card {
    public static int numReminders;
    int margin;
    Activity activity;
    public String name;
    public String description;
    public String inventory;
    public String cost;

    public StoreCard(Activity activity){
        super(activity);
        this.activity = activity;
        margin = Metrics.convertDpToPixel(activity.getBaseContext(),5);
    }

    public void makeCard(String[] messages) {
        name = messages[0];
        description = messages[1];
        cost = messages[2];
        inventory = messages[3];
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
