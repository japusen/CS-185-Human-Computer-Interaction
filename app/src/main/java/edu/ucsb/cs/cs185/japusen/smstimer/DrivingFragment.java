package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alickxu on 6/8/15.
 */
public class DrivingFragment extends DialogFragment {
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =  getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View addView = inflater.inflate(R.layout.driving_layout, container, false);

        return addView;
    }
}
