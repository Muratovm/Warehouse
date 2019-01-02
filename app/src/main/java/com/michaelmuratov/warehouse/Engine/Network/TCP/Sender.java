package com.michaelmuratov.warehouse.Engine.Network.TCP;


import android.app.Activity;
import android.util.Log;

import org.json.JSONObject;

public class Sender {

Activity activity;
    public Sender(Activity activity){
        this.activity = activity;
    }

    public void sendTCP(String type, JSONObject message) {
        String response = "";
        TCPFactory tcpFactory = new TCPFactory();
        MyTCP tcp = tcpFactory.getTCP(type, activity);
        Log.d("Network", "Got to send message");
        try {
            tcp.execute(message);
            //Log.d("data",""+response);
        } catch (Exception ex) {
            Log.d("Network Exception", "" + ex.toString());
            Log.d("Network Exception", "" + ex.getMessage());
            Log.d("Network Exception", "" + ex.getStackTrace());
        }
    }
}
