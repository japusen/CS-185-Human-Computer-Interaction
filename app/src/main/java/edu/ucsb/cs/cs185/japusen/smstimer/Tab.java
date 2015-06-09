package edu.ucsb.cs.cs185.japusen.smstimer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Tab extends ListFragment {
    public static final String SETTINGS = "AutoTextApp";
    public static final String PENDING = "PendingMessages";
    public static final String SENT = "SentMessages";
    public final int DELAY = 0;
    public final int LOCATION = 1;
    public final int CONTACT = 2;
    public final int DRIVING = 3;
    ArrayList<Event> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab, container, false);

        //ListView list = getListView(); //(ListView) v.findViewById(android.R.id.list);

        Bundle bundle = this.getArguments();
        String type = bundle.getString("type");

        if(Objects.equals(type, "pending"))
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

        //list.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        Event event = (Event) getListView().getItemAtPosition(position);
        String header = event.getHeader();
        String message = event.getMessage();

        switch(event.getType()) {
            case DELAY:
                delayEvent delay = (delayEvent) event;
                String time = delay.getTime();
                String date = delay.getDate();

                break;
            case LOCATION:
                locationEvent location = (locationEvent) event;
                String destination = location.getLocation();
                double distance = location.getDistance();

                break;
            case CONTACT:
                contactEvent contact = (contactEvent) event;
                String number = contact.getNumber();

                break;
            case DRIVING:
                drivingEvent drive = (drivingEvent) event;
                double speed = drive.getSpeed();

                break;
            default:
                break;
        }

        Toast.makeText(getActivity(), event.getHeader(), Toast.LENGTH_SHORT).show();
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