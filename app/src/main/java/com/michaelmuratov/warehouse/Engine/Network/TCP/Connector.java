package com.michaelmuratov.warehouse.Engine.Network.TCP;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connector {

    public static boolean isConnected(Activity activity){
        ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}
