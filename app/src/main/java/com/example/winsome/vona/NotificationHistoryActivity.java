package com.example.winsome.vona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotificationHistoryActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
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
