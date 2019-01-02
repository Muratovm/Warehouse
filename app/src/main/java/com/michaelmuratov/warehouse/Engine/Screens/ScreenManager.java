package com.michaelmuratov.warehouse.Engine.Screens;

import android.app.Activity;
import android.content.Context;
import android.widget.ViewFlipper;

import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;
import com.michaelmuratov.warehouse.Engine.Util.Visual.MyAnimation;
import com.michaelmuratov.warehouse.R;

public class ScreenManager {
    Context context;
    public MyAnimation myAnimation;
    public ViewFlipper tab_flipper;
    public ViewFlipper activity_flipper;
    public Tab[] tabs = new Tab[5];
    public Tab[] new_tab = new Tab[5];
    public Reminders reminder;

    public ScreenManager(Activity activity){
        context = activity.getBaseContext();
        /*
        new_tab[0] = new Lock(activity);
        new_tab[1] = new Forum(context, activity);
        new_tab[2] = new Notes(activity);
        new_tab[3] = new Reminders(activity);
        new_tab[4] = new Settings(activity,this);
        */
        reminder = (Reminders) new_tab[3];
        for(int i =0; i<new_tab.length;i++){
            initializeTab(i);
        }

        myAnimation = new MyAnimation(context);
        tab_flipper = activity.findViewById(R.id.vf);
        activity_flipper = activity.findViewById(R.id.activities);

        tab_flipper.setInAnimation(context, R.anim.slide_in_bottom);
        tab_flipper.setOutAnimation(context, R.anim.zoom_out);
    }

    public void PressBack(){
        tab_flipper.setDisplayedChild(0);
    }

    public void ShowNextActivity(){
        activity_flipper.showNext();
    }

    public void setAnimation(){

        tab_flipper.setInAnimation(context, R.anim.slide_in_bottom);
        tab_flipper.setOutAnimation(context, R.anim.zoom_out);

    }

    public void initializeTab(int position){
        if(Features.tabs[position]){tabs[position] = new_tab[position];}
    }
}
