package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by alickxu on 6/5/15.
 */
public class DelayFragment extends DialogFragment {
    private Context context;
    private Button dateTimeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =  getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View delayView = inflater.inflate(R.layout.delay_layout, container, false);
        dateTimeButton = (Button) delayView.findViewById(R.id.dateTimePicker);
        dateTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        return delayView;
    }
}

