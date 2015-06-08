package edu.ucsb.cs.cs185.japusen.smstimer;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Event> {
    public final int DELAY = 0;
    public final int LOCATION = 1;
    public final int CONTACT = 2;
    public final int DRIVING = 3;

    private Context context;
    private ArrayList<Event> events;

    public MyArrayAdapter(Context context, ArrayList<Event> events) {
        super(context, R.layout.list_item, events);
        this.context = context;
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View list_view = inflater.inflate(R.layout.list_item, parent, false);
        ImageView imageView = (ImageView) list_view.findViewById(R.id.icon);
        TextView top = (TextView) list_view.findViewById(R.id.top);
        TextView middle = (TextView) list_view.findViewById(R.id.middle);
        TextView bottom = (TextView) list_view.findViewById(R.id.bottom);

        Event event = events.get(position);

        switch(event.getType()) {
            case DELAY:
                delayEvent delay = (delayEvent) event;
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText(delay.getHeader());
                middle.setText(delay.getDate() + " " + delay.getTime());
                bottom.setText(delay.getMessage());
                break;
            case LOCATION:
                locationEvent location = (locationEvent) event;
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText(location.getHeader());
                middle.setText(location.getLocation());
                bottom.setText(location.getMessage());
                break;
            case CONTACT:
                contactEvent contact = (contactEvent) event;
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText(contact.getHeader());
                middle.setText(contact.getNumber());
                bottom.setText(contact.getMessage());
                break;
            case DRIVING:
                drivingEvent drive = (drivingEvent) event;
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText("Driving Mode");
                middle.setText(Float.toString(drive.getSpeed()));
                bottom.setText(drive.getMessage());
                break;
            default:
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText("Shit,");
                middle.setText("It's fucked up.");
                bottom.setText("God damn.");
                break;
        }

        return list_view;
    }
}
