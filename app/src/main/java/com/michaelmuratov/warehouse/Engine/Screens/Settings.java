package com.michaelmuratov.warehouse.Engine.Screens;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.michaelmuratov.warehouse.Engine.Navigation.Navigation;
import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;

public class Settings extends Tab{

    int last_pos = 4;

    public Settings(final Activity activity, final ScreenManager screenManager){
        /*
        setListener(activity,R.id.check_lock,0,screenManager);
        setListener(activity,R.id.check_forum,1,screenManager);
        setListener(activity,R.id.check_notes,2,screenManager);
        setListener(activity,R.id.check_reminders,3,screenManager);
        setListener(activity,R.id.check_settings,4,screenManager);
        */
    }

    public void setListener(final Activity activity, int id, final int position, final ScreenManager screenManager){
        final CheckBox box = activity.findViewById(id);
        if(Features.tabs[position]){
            box.setChecked(true);
        }
        box.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton
                                                         buttonView,boolean isChecked) {
                        if(isChecked){
                            Features.tabs[position] = true;
                            screenManager.initializeTab(position);
                        }
                        else{
                            if(position != last_pos){
                                Features.tabs[position] = false;
                            }
                            else{
                                box.setChecked(true);
                                Toast.makeText(activity,"Don't uncheck this",Toast.LENGTH_SHORT).show();
                            }
                        }
                        Navigation.revalidateXML(activity);
                    }
                }
        );
    }
}
