package com.michaelmuratov.warehouse.Engine.Network.TCP;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.michaelmuratov.warehouse.Engine.Application.LockController;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MetaTCP extends MyTCP{

    private Activity activity;

    public MetaTCP(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Object[] params){
        return send((JSONObject) params[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("data",""+result);
        Log.d("desired",""+"{\"STATUS\": \"AUTHENTICATED\"}");
        if(result.equals("{\"STATUS\": \"AUTHENTICATED\"}")) {
            //LockController.setPreferredHomeActivity(activity.getBaseContext(), Lock_Out.class, Lock_In.class);
            LockController.callHome(activity.getBaseContext());
            activity.finish();
        }
    }


    public String send(JSONObject message) {
        String data = "";
        try {
            // Creating new socket connection to the IP (first parameter) and its opened port (second parameter)
            Socket s = new Socket("136.243.90.91", 7475);
            InputStream nis = s.getInputStream();
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            out.write(message.toString());
            out.flush();
            data = listen(nis);
            // Close the socket connection
            s.close();
            //Log.d("data",""+data);
        } catch (Exception ex) {
            Log.d("Network Exception", "" + ex.toString());
            Log.d("Network Exception", "" + ex.getMessage());
            Log.d("Network Exception", "" + ex.getStackTrace());
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(activity, "Could not send data to server", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return data;
    }
}

