package com.michaelmuratov.warehouse.Engine.Navigation;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;
import com.michaelmuratov.warehouse.R;

import java.util.ArrayList;


/**
 * Class responsible for the most paseline 
 */
public class Navigation implements NavigationView.OnNavigationItemSelectedListener{

    static BottomNavigationView navigation;
    protected ViewFlipper vf;
    Context context;
    private String activeTab = "Lock";
    private static Menu menuNav;
    private static ArrayList<MenuItem> items = new ArrayList<>();
    private static ArrayList<Integer> ids = new ArrayList<>();
    private static ArrayList<Integer> icons = new ArrayList<>();
    private static ArrayList<String> strings = new ArrayList<>();
    static int j =0;


    public Navigation(Activity activity){
        this.context = activity.getBaseContext();
        add_tab(R.id.navigation_lock,  R.drawable.img_lock_closed,  "Lock");
        add_tab(R.id.navigation_forum,  R.drawable.img_forum,  "Forum");
        add_tab(R.id.navigation_notes,  R.drawable.img_notes,  "Notes");
        add_tab(R.id.navigation_reminders,  R.drawable.img_bell,  "Reminders");
        add_tab(R.id.navigation_settings,  R.drawable.img_settings,  "Settings");

    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return createChoices(item);
        }
    };

    private boolean createChoices(MenuItem item){
        for(int i = 0; i < ids.size(); i++) {
            if (item.getItemId() == ids.get(i)) {
                activeTab = strings.get(i);
                Toast.makeText(context,activeTab,Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    public void initialize(Activity activity){
        menuNav = navigation.getMenu();
        items.set(0, menuNav.findItem(R.id.navigation_lock));
        items.set(1, menuNav.findItem(R.id.navigation_forum));
        items.set(2, menuNav.findItem(R.id.navigation_notes));
        items.set(3, menuNav.findItem(R.id.navigation_reminders));
        items.set(4, menuNav.findItem(R.id.navigation_settings));
        revalidateXML(activity);
    }


    public void add_tab(int id, int icon, String name){
        ids.add(id);
        icons.add(icon);
        strings.add(name);
    }

    public void setViewFlipper(ViewFlipper viewFlipper){
        vf = viewFlipper;
    }

    public ViewFlipper getViewFlipper(){
        return vf;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mOnNavigationItemSelectedListener.onNavigationItemSelected(item);
        return true;
    }

    public static void revalidateXML(Activity activity){
        menuNav.clear();
        for(int j = 0; j<5; j++){
            setFeature(j);
        }
        j=0;
    }

    public static void setFeature(int i){
        if(Features.tabs[i]){
            menuNav.add(items.get(i).getGroupId(),items.get(i).getItemId(),j,strings.get(i));
            menuNav.getItem(j).setIcon(icons.get(i));
            j++;
        }
    }
}
