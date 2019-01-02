package com.michaelmuratov.warehouse.Engine.Network.TCP;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;

public abstract class MyTCP extends AsyncTask<Object,Integer,String> {

    String response = "place holder";

    @Override
    protected abstract String doInBackground(Object[] params);

    @Override
    protected abstract void onPostExecute(String result);

    protected String listen(InputStream nis) throws IOException {
        String data = "";
        int current=0;
        while(true){
            current = nis.read();
            if(current =='\r'){
                current = nis.read();
                if(current == '\n'){
                    break;
                }
            }
            data += ""+(char)current;
        }
        return data;
    }
}
