package edu.ucsb.cs.cs185.japusen.smstimer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.gson.Gson;
import com.melnykov.fab.FloatingActionButton;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends ActionBarActivity  {

    FloatingActionButton fab;
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Pending", "Sent"};
    int Numboftabs = 2;
    ArrayList<Event> pending;
    ArrayList<Event> sent;
    public static final String SETTINGS = "AutoTextApp";
    public static final String PENDING = "PendingMessages";
    public static final String SENT = "SentMessages";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //get Lists
        pending = getPending(this);
        sent = getSent(this);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs, pending, sent);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked FAB", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.delete) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void savePending(Context context, ArrayList<Event> pending) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(SETTINGS,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonPending = gson.toJson(pending);

        editor.putString(PENDING, jsonPending);
        editor.commit();
    }

    public ArrayList<Event> getPending(Context context) {
        SharedPreferences settings;
        ArrayList<Event> pending;

        settings = context.getSharedPreferences(SETTINGS,
                Context.MODE_PRIVATE);

        if (settings.contains(PENDING)) {
            String jsonFavorites = settings.getString(PENDING, null);
            Gson gson = new Gson();
            Event[] pendingItems = gson.fromJson(jsonFavorites,
                    Event[].class);

            pending = new ArrayList<Event>(Arrays.asList(pendingItems));
        }
        else
            pending = new ArrayList<Event>();

        return pending;
    }

    public void saveSent(Context context, ArrayList<Event> sent) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(SETTINGS,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonSent = gson.toJson(sent);

        editor.putString(SENT, jsonSent);
        editor.commit();
    }

    public ArrayList<Event> getSent(Context context) {
        SharedPreferences settings;
        ArrayList<Event> sent;

        settings = context.getSharedPreferences(SETTINGS,
                Context.MODE_PRIVATE);

        if (settings.contains(SENT)) {
            String jsonFavorites = settings.getString(SENT, null);
            Gson gson = new Gson();
            Event[] sentItems = gson.fromJson(jsonFavorites,
                    Event[].class);

            sent = new ArrayList<Event>(Arrays.asList(sentItems));
        }
        else
            sent = new ArrayList<Event>();

        return sent;
    }
}
