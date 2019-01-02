package com.michaelmuratov.warehouse.Engine.Navigation;

import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;
import com.michaelmuratov.warehouse.MainActivity;

public class Topbar {

    Activity activity;
    Toolbar toolbar;
    Drawer drawer;

    public Topbar(Activity activity){
        this.activity = activity;
        drawer = new Drawer(activity);
    }

    public void setup_Toolbar(MainActivity myActivity, int toolbar_view, int app_bar_layout){
        if(Features.toolbar){
            toolbar = activity.findViewById(toolbar_view);         //in app_bar_main.xml
            myActivity.setSupportActionBar(toolbar);
        }
        else{
            AppBarLayout applay = activity.findViewById(app_bar_layout);
            applay.setVisibility(View.GONE);
        }
    }

    public void setUpDrawer(int drawerlayout, int nav_view){
        drawer.setup_Drawer(toolbar,drawerlayout,nav_view);
    }
}
