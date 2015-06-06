package edu.ucsb.cs.cs185.japusen.smstimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

public class Tab1 extends Fragment {
    LinkedList<String> myDataset;
    RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);
        FragmentActivity activity = getActivity();

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.tab1_rv);

        myDataset = new LinkedList<String>();

        myDataset.add("One");
        myDataset.add("Two");
        myDataset.add("Three");

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(activity, myDataset);
        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }
}