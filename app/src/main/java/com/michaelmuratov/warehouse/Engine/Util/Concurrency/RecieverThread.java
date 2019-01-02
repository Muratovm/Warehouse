package com.michaelmuratov.warehouse.Engine.Util.Concurrency;

import com.michaelmuratov.warehouse.Engine.Network.TCP.MyTCP;

/**
 * Created by Michael on 11/1/2017.
 */

public class RecieverThread extends MyThread{
    MyTCP tcp;

    public RecieverThread(MyTCP tcp){
        this.tcp = tcp;
    }

    public void run(){
       // tcp.recieve();
    }

}
