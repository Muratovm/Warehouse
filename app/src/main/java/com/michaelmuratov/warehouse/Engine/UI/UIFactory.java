package com.michaelmuratov.warehouse.Engine.UI;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.widget.ViewFlipper;

import com.michaelmuratov.warehouse.Engine.Navigation.Drawer;


public class UIFactory {
    public UIComponent createComponent(String component, Activity activity, Toolbar toolbar, ViewFlipper viewFlipper){
        if(component.equals("drawer")) return new Drawer(activity);
        return null;
    }
}
