package com.michaelmuratov.warehouse.Engine.Screens;


import android.app.Activity;
import android.content.Context;

import com.michaelmuratov.warehouse.Engine.Network.Messages.Chats;

public class Forum extends Tab{
    Context context;

    public Forum(Context context, Activity activity){
        this.context = context;

        Chats chats = new Chats(activity);

    }
}
