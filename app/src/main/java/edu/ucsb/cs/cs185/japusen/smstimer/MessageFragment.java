package edu.ucsb.cs.cs185.japusen.smstimer;

import android.app.Activity;
import android.app.DialogFragment;

/**
 * Created by alickxu on 6/9/15.
 */
public class MessageFragment extends DialogFragment {
    OnDataPass dataPasser;
    /*
    Interface to pass data back to NewMessageActivity
     */
    public interface OnDataPass {
        public void onDataPass(String data);
    }

    @Override
    public void onAttach(Activity a){
        super.onAttach(a);

        // makes sure activity has implemented callback interface
        try {
            dataPasser = (OnDataPass) a;
        } catch (ClassCastException e) {
            throw new ClassCastException(a.toString() + " must implement OnDataPass");
        }
    }

    public void passData(String data) {
        dataPasser.onDataPass(data);
    }
}
