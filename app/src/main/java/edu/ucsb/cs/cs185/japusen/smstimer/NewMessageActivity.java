package edu.ucsb.cs.cs185.japusen.smstimer;

/**
 * Created by alickxu on 6/5/15.
 */


import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class NewMessageActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_message_activity);
        Spinner spinner = (Spinner) findViewById(R.id.message_type);

        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.message_choices,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // fragment manager
        fragmentManager = getFragmentManager();
    }

    // Select a message type from the spinner
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Item selected
        String select = (String)parent.getItemAtPosition(pos);
        Log.w("onItemSelected", select);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (select) {
            case "Delayed":
                DelayFragment delay = new DelayFragment();
                fragmentTransaction.replace(R.id.message_fragment_container, delay);
                fragmentTransaction.addToBackStack(null);
                break;
            case "Location":
                LocationFragment loc = new LocationFragment();
                fragmentTransaction.replace(R.id.message_fragment_container, loc);
                fragmentTransaction.addToBackStack(null);
                break;
            case "Adding Contact":
                AddContactFragment contact = new AddContactFragment();
                fragmentTransaction.replace(R.id.message_fragment_container, contact);
                fragmentTransaction.addToBackStack(null);
                break;
            case "Drive Mode":
                DrivingFragment drive = new DrivingFragment();
                fragmentTransaction.replace(R.id.message_fragment_container, drive);
                fragmentTransaction.addToBackStack(null);
                break;

        }
        fragmentTransaction.commit();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        Log.w("onNothingSelected", "nothing selected");
    }



}
