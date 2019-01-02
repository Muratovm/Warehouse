package com.michaelmuratov.warehouse.Engine.Listeners;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected = (String) parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}