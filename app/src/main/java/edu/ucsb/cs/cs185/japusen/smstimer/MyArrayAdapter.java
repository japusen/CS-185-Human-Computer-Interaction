package edu.ucsb.cs.cs185.japusen.smstimer;


import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
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
                Drawable dIcon = list_view.getResources().getDrawable(R.mipmap.alarm24);
                ColorFilter dFilter = new LightingColorFilter(0x4CAF50, 0);
                dIcon.setColorFilter(dFilter);
                imageView.setImageDrawable(dIcon);
                top.setText(delay.getHeader());
                middle.setText(delay.getDate() + " " + delay.getTime());
                bottom.setText(delay.getMessage());
                break;
            case LOCATION:
                locationEvent location = (locationEvent) event;
                Drawable lIcon = list_view.getResources().getDrawable(R.mipmap.room24);
                ColorFilter lFilter = new LightingColorFilter(0xF44336, 0);
                lIcon.setColorFilter(lFilter);
                imageView.setImageDrawable(lIcon);
                top.setText(location.getHeader());
                middle.setText(location.getLocation());
                bottom.setText(location.getMessage());
                break;
            case CONTACT:
                contactEvent contact = (contactEvent) event;
                Drawable cIcon = list_view.getResources().getDrawable(R.mipmap.acc24);
                ColorFilter cFilter = new LightingColorFilter(0xF57F17, 0);
                cIcon.setColorFilter(cFilter);
                imageView.setImageDrawable(cIcon);
                top.setText(contact.getHeader());
                middle.setText(contact.getNumber());
                bottom.setText(contact.getMessage());
                break;
            case DRIVING:
                drivingEvent drive = (drivingEvent) event;
                Drawable drIcon = list_view.getResources().getDrawable(R.mipmap.car24);
                ColorFilter drFilter = new LightingColorFilter(0x3F51B5, 0);
                drIcon.setColorFilter(drFilter);
                imageView.setImageDrawable(drIcon);
                top.setText("Driving Mode");
                middle.setText(Double.toString(drive.getSpeed()) + " mph");
                bottom.setText(drive.getMessage());
                break;
            default:
                imageView.setImageResource(R.mipmap.ic_launcher);
                top.setText("Shit,");
                middle.setText("It's not supposed to get here");
                bottom.setText("Uh oh.");
                break;
        }

        return list_view;
    }
}
