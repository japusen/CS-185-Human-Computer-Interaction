package edu.ucsb.cs.cs185.japusen.smstimer;

/**
 * Created by alickxu on 6/5/15.
 */


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class NewMessageActivity extends Activity implements AdapterView.OnItemSelectedListener {

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
    }

    // Select a message type from the spinner
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Item selected
        String select = (String)parent.getItemAtPosition(pos);
        Log.w("onItemSelected", select);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        Log.w("onNothingSelected", "nothing selected");
    }

}
