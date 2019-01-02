package com.michaelmuratov.warehouse.Engine.Network.TCP;

import android.app.Activity;

class TCPFactory {
    MyTCP getTCP(String TCP, Activity activity){
        switch (TCP){
            case "Message": return new ForumTCP(activity);
            case "Meta": return new MetaTCP(activity);
        }
        return null;
    }
}
