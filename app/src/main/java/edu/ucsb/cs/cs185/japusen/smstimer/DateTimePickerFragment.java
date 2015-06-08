package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alickxu on 6/8/15.
 */
public class DateTimePickerFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.custom_dialog, container, false);
        getDialog().setTitle("Enter Date/Time");
        return rootView;
    }
}
