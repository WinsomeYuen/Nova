package com.example.winsome.vona;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class NotificationHistoryActivity extends AppCompatActivity{
    private DrawerLayout mDrawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent myIntent;
                        // Handle item selection
                        switch (menuItem.getItemId()) {
                            case R.id.login:
                                myIntent = new Intent(NotificationHistoryActivity.this, LoginActivity.class);
                                startActivity(myIntent);
                                return true;
                            case R.id.notify:
                                myIntent = new Intent(NotificationHistoryActivity.this, NotificationHistoryActivity.class);
                                startActivity(myIntent);
                                return true;
                            case R.id.makenotify:
                                myIntent = new Intent(NotificationHistoryActivity.this, MakeActivity.class);
                                startActivity(myIntent);
                                return true;
                            case R.id.settings:
                                myIntent = new Intent(NotificationHistoryActivity.this, Settings.class);
                                startActivity(myIntent);
                                return true;
                            case R.id.demo:
                                myIntent = new Intent(NotificationHistoryActivity.this, DemoActivity.class);
                                startActivity(myIntent);
                                return true;
                            default:
                                return true;
                        }
                    }
                });

        final ArrayList<Notification> covers = new ArrayList<Notification>();
        covers.add(new Notification("Low in stock", "You need to update the stock amount for X item on shelf F of storage section B","21/02/2018"));
        covers.add(new Notification("Discount on product", "Need to ensure that all prices are changed for X product across the store","08/02/2018"));
        covers.add(new Notification("Missing Stock", "Check stock count as the current stock calculated is less than there should be","23/01/2018"));
        covers.add(new Notification("Low in stock", "You need to update the stock amount for X item on shelf F of storage section B","21/02/2018"));
        covers.add(new Notification("Discount on product", "Need to ensure that all prices are changed for X product across the store","08/02/2018"));
        covers.add(new Notification("Missing Stock", "Check stock count as the current stock calculated is less than there should be","23/01/2018"));
        covers.add(new Notification("Low in stock", "You need to update the stock amount for X item on shelf F of storage section B","21/02/2018"));
        covers.add(new Notification("Discount on product", "Need to ensure that all prices are changed for X product across the store","08/02/2018"));
        covers.add(new Notification("Missing Stock", "Check stock count as the current stock calculated is less than there should be","23/01/2018"));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
