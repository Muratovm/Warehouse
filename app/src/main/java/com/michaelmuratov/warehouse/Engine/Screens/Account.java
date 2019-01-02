package com.michaelmuratov.warehouse.Engine.Screens;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ViewFlipper;

import com.michaelmuratov.warehouse.Engine.Navigation.Drawer;
import com.michaelmuratov.warehouse.Engine.States.MyActivity;
import com.michaelmuratov.warehouse.Engine.Util.Visual.Features;
import com.michaelmuratov.warehouse.Engine.Util.Visual.MyAnimation;
import com.michaelmuratov.warehouse.Engine.Util.Visual.Toolbox;
import com.michaelmuratov.warehouse.R;

public class Account extends AppCompatActivity {

    private MyActivity activity;
    private Toolbox toolbox;
    private Toolbar toolbar;
    private Drawer drawer;
    private ScreenManager screenManager;


    public Account(MyActivity activity, Toolbox toolbox){
        this.activity = activity;
        this.toolbox = toolbox;
    }


    public void showAccount(){
        this.toolbar = toolbox.toolbar;
        this.drawer = toolbox.drawer;
        this.screenManager = activity.screenManager;

        toolbar.getMenu().clear();
        if(Features.drawer) {
            drawer.hideDrawer();
        }
        Account.inAnimations(screenManager.myAnimation,screenManager.activity_flipper);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toolbar.inflateMenu(R.menu.account);
                        if(Features.drawer) {
                            drawer.showDrawer();
                        }
                        Account.outAnimations(screenManager.myAnimation,screenManager.activity_flipper);
                        screenManager.activity_flipper.showPrevious();
                    }
                });
    }

    private static void inAnimations(MyAnimation myAnimation, ViewFlipper act){
        myAnimation.setInAnimation(act, R.anim.slide_left_next);
        myAnimation.setOutAnimation(act, R.anim.slide_left_current);
    }

    private static void outAnimations(MyAnimation myAnimation, ViewFlipper act){
        myAnimation.setInAnimation(act, R.anim.slide_right_next);
        myAnimation.setOutAnimation(act, R.anim.slide_right_current);
    }
}
