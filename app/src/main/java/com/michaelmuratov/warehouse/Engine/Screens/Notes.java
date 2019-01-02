package com.michaelmuratov.warehouse.Engine.Screens;


import android.app.Activity;
import android.widget.TextView;

import com.michaelmuratov.warehouse.R;


public class Notes extends Tab{
    public Notes(Activity activity){
        TextView view = activity.findViewById(R.id.note);
        view.setText("Hey look at this text man, this is an extremely long ");
    }
}
