package com.example.winsome.vona;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotificationHistoryActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.notification_list);

        final ArrayList<Notification> covers = new ArrayList<Notification>();
        covers.add(new Notification("You smell", "You need to shower shithead","21/02/2018"));
        covers.add(new Notification("I like turtles", "Tutles are super cool","08/02/2018"));
        covers.add(new Notification("Calvin likes dick", "That's why his body hurts all the time","23/01/2018"));
        NotificationAdapter adapter = new NotificationAdapter(this, covers);
        ListView listView = (ListView) findViewById(R.id.notification_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Notification cover = covers.get(position);
            }
        });
    }
}
