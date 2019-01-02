package com.michaelmuratov.warehouse.Engine.States;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.michaelmuratov.warehouse.Engine.Screens.Reminders;
import com.michaelmuratov.warehouse.Engine.Screens.ScreenManager;
import com.michaelmuratov.warehouse.Engine.UI.Dialogs.ReminderDialog;
import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;

public class MyActivity extends AppCompatActivity implements ReminderDialog.OnCompleteListener{
    public ScreenManager screenManager;

    @Override
    public void onComplete(String[] strings) {
        if(Features.tabs[3]){screenManager.reminder.makeReminder(this,strings);}
        setTime();
    }

    public void setTime() {
        Intent notifyIntent = new Intent(this, Reminders.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                1000, pendingIntent);
    }
}
