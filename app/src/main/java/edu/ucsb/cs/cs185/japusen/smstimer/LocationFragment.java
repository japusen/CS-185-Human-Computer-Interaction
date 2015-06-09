package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by alickxu on 6/7/15.
 */
public class LocationFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_layout, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.map);
        img.setImageResource(R.drawable.map_close);
        return view;
    }
}
