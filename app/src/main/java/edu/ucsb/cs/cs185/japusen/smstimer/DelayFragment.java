package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alickxu on 6/5/15.
 */
public class DelayFragment extends DialogFragment {
    private Context context;
    private Button dateButton;
    private Button timeButton;

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";

    public static TextView theDate, theTime;

    // Variable for storing current date
    private int mYear, mMonth, mDay;

    // Storing address book contacts
    private ArrayList<Map<String, String>> mPeopleList;
    private AutoCompleteTextView enterContact;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =  getActivity();
        mPeopleList = new ArrayList<Map<String, String>>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View delayView = inflater.inflate(R.layout.delay_layout, container, false);

        enterContact = (AutoCompleteTextView) delayView.findViewById(R.id.enter_contact);
        enterContact.setAdapter(new ArrayAdapter<String>(context, R.layout.contact_element, R.id.ccontName, getAllContactNames()));

        theDate = (TextView) delayView.findViewById(R.id.theDate);
        theTime = (TextView) delayView.findViewById(R.id.theTime);
        dateButton = (Button) delayView.findViewById(R.id.datePicker);
        timeButton = (Button) delayView.findViewById(R.id.timePicker);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });

        return delayView;
    }

    private List<String> getAllContactNames() {
        List<String> lContactNamesList = new ArrayList<String>();
        try {
            // Get all Contacts
            Cursor lPeople = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (lPeople != null) {
                while (lPeople.moveToNext()) {
                    // Add Contact's Name into the List
                    lContactNamesList.add(lPeople.getString(lPeople.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                }
            }
        } catch (NullPointerException e) {
            Log.e("getAllContactNames()", e.getMessage());
        }
        return lContactNamesList;
    }



    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }

    public void showDatePickerDialog(View v) {
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Display Selected date in textbox
                        theDate.setText(getMonth(monthOfYear) + " "
                                + dayOfMonth + ", " + year);

                        // Send selected date back to activity
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        String formattedDate = sdf.format(new Date(year, monthOfYear, dayOfMonth));

                        Intent intent = new Intent(getActivity().getBaseContext(), NewMessageActivity.class);
                        intent.putExtra("date", formattedDate);
                        getActivity().startActivity(intent);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void showTimePickerDialog(View v) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog
        TimePickerDialog tpd = new TimePickerDialog(context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Display selected time
                        theTime.setText(hourOfDay + ":" + minute);

                        // Send selected date back to activity
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        long milliseconds = minute*60 + hourOfDay*3600 * 1000;
                        String formattedTime = sdf.format(milliseconds);

                        Intent intent = new Intent(getActivity().getBaseContext(), NewMessageActivity.class);
                        intent.putExtra("time", formattedTime);
                        getActivity().startActivity(intent);
                    }
                }, hour, minute,
                DateFormat.is24HourFormat(context));
        tpd.show();
    }
}

