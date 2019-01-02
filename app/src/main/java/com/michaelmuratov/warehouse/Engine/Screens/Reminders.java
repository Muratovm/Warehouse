package com.michaelmuratov.warehouse.Engine.Screens;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.michaelmuratov.warehouse.Engine.Listeners.RecyclerTouchListener;
import com.michaelmuratov.warehouse.Engine.UI.Cards.CardAdapter;
import com.michaelmuratov.warehouse.Engine.UI.Cards.ReminderCard;
import com.michaelmuratov.warehouse.Engine.UI.Dialogs.ReminderDialog;
import com.michaelmuratov.warehouse.R;

import java.util.ArrayList;
import java.util.List;

public class Reminders extends Tab{

    private Activity activity;
    private List<ReminderCard> cardList = new ArrayList<>();
    private CardAdapter mAdapter;

    public Reminders(final Activity activity) {
        this.activity = activity;
        RecyclerView recyclerView = activity.findViewById(R.id.recycler_view);

        mAdapter = new CardAdapter(cardList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(activity.getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ReminderCard card = cardList.get(position);
                Toast.makeText(activity.getBaseContext(), card.title + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        spawnFloatingButton();
    }







    public void makeReminder(Activity activity, String[] strings){
        ReminderCard card = new ReminderCard(activity);
        card.makeCard(strings);
        cardList.add(card);
        mAdapter.notifyDataSetChanged();
        //layout.addView(card,linear);
    }

    public void spawnFloatingButton(){
        FloatingActionButton fab = activity.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = activity.getFragmentManager();
                ReminderDialog dialogFragment = new ReminderDialog();
                dialogFragment.show(fm, "Sample Fragment");

            }
        });
    }
}
