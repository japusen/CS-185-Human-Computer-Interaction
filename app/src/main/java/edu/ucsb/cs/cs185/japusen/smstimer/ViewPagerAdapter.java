package edu.ucsb.cs.cs185.japusen.smstimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    ArrayList<Event> pending;
    ArrayList<Event> sent;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, ArrayList<Event> pending, ArrayList<Event> sent) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.pending = pending;
        this.sent = sent;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) {// if the position is 0 we are returning the First tab
            Tab tab = new Tab();
            //tab.setArguments();
            //pending

            Bundle bundle = new Bundle();
            bundle.putString("type", "pending");
            tab.setArguments(bundle);
            return tab;
        }
        else {            // As we are having 2 tabs if the position is not 0 it must be 1 so we are returning second tab
            Tab tab = new Tab();
            //tab.setArguments
            //sent
            Bundle bundle = new Bundle();
            bundle.putString("type", "sent");
            tab.setArguments(bundle);
            return tab;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}