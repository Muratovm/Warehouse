package com.michaelmuratov.warehouse.Engine.Util.Visual;

import android.content.Context;
import android.widget.ViewFlipper;

public class MyAnimation {

    private Context context;

    public MyAnimation(Context context) {
        this.context = context;
    }

    public void setInAnimation(ViewFlipper vf, int animation) {
        vf.setInAnimation(context, animation);
    }

    public void setOutAnimation(ViewFlipper vf, int animation) {
        vf.setOutAnimation(context, animation);
    }

}
