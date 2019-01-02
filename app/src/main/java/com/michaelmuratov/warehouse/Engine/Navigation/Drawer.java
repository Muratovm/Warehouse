package com.michaelmuratov.warehouse.Engine.Navigation;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.michaelmuratov.warehouse.Engine.UI.UIComponent;
import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;
import com.michaelmuratov.warehouse.R;


public class Drawer extends Navigation implements UIComponent {

    private Activity activity;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    int drawer_layout;

    private int open = R.string.navigation_drawer_open;
    private int close= R.string.navigation_drawer_close;

    /*
     * Recieves the selected item's id and closes the drawer
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mOnNavigationItemSelectedListener.onNavigationItemSelected(item);
        navigation.setSelectedItemId(item.getItemId());
        DrawerLayout drawer = activity.findViewById(R.id.drawer_layout); //gets instance of drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
     * Creates a side drawer
     */
    public Drawer(Activity activity){
        super(activity);
        this.activity= activity;

    }

    public void setup_Drawer(Toolbar toolbar,int drawer_layout, int nav_view){
        this.drawer_layout = drawer_layout;
        NavigationView navigationView = activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(Features.drawer) {
            DrawerLayout drawer = activity.findViewById(drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    activity, drawer, toolbar, open, close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        }
        else{
            DrawerLayout drawlay = activity.findViewById(drawer_layout);
            drawlay.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    /*
     * Makes the drawer unusable
     */
    public void hideDrawer(){toggle.setDrawerIndicatorEnabled(false);}

    /*
     * Makes the drawer usable again
     */
    public void showDrawer(){
        toggle.setDrawerIndicatorEnabled(true);
    }

    public String toString(){
        return "ID: "+drawer.getId();
    }
}
