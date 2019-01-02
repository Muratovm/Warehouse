package com.michaelmuratov.warehouse.Engine.Navigation;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;

/**
 * Sets up the bottom navigation menu
 */
public class BottomNavigation extends Navigation{


    /**
     * Sets up the defaults of the bottom navigation
     * @param activity Activity context
     */
    public BottomNavigation(Activity activity){
        super(activity);
        context = activity.getBaseContext();

    }

    public void setupBottomNavigationView(Activity activity, int bottom_nav, int nav_view){
        if(Features.bottomNavigation) {
            NavigationView navigationView = activity.findViewById(nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigation = activity.findViewById(bottom_nav);
            navigation.setSaveEnabled(true);
            navigation.setBackgroundColor(Color.rgb(250,250,250));
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            initialize(activity);
        }
        else{
            BottomNavigationView bnv = activity.findViewById(bottom_nav);
            bnv.setVisibility(View.GONE);

        }
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mOnNavigationItemSelectedListener.onNavigationItemSelected(item);
        navigation.setSelectedItemId(item.getItemId());
        return true;
    }

    public BottomNavigationView getNavigation(){
        return navigation;
    }

}
