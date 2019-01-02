package com.michaelmuratov.warehouse.Engine.Util.Concurrency;

import android.app.Activity;

/**
 * Created by Michael on 2017-10-25.
 */

public class MessageThread extends MyThread{

    Activity activity;

    public MessageThread(Activity activity){
        this.activity = activity;
    }

    public void run() {
        //Chats chats = new Chats(activity);
    }

}
