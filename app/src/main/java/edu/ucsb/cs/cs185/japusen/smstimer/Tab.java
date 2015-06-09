package edu.ucsb.cs.cs185.japusen.smstimer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;


public class Tab extends ListFragment {
    public static final String SETTINGS = "AutoTextApp";
    public static final String PENDING = "PendingMessages";
    public static final String SENT = "SentMessages";

    String[] list_items;

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
            //pending = new List<Event>(pending);
        }
        else
            pending = new ArrayList<Event>();

        return pending;
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
            //sent = new List<Event>(sent);
        }
        else
            sent = new ArrayList<Event>();

        return sent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab, container, false);
        ArrayList<Event> data;

        Bundle bundle = this.getArguments();
        String type = bundle.getString("type");

        if(type == "pending")
            data = getPending(getActivity());
        else
            data = getSent(getActivity());

        drivingEvent event = new drivingEvent(3, "don't bother me", "Driving Mode", 25.0);
        data.add(event);
        locationEvent location = new locationEvent(1, "on my way", "John", "123 St", 1.00);
        data.add(location);
        delayEvent delay = new delayEvent(0, "t minus 25 until the game starts. dont forget to bring the food." +
                                             "see you soon.", "Sarah", "12:00pm", "6/5/16");
        data.add(delay);
        contactEvent contact = new contactEvent(2, "this is Jay", "Jane", "555 555 5555");
        data.add(contact);


        MyArrayAdapter adapter = new MyArrayAdapter(getActivity(), data);
        setListAdapter(adapter);

        return v;
    }
}