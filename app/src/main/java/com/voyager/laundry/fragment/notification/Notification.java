package com.voyager.laundry.fragment.notification;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voyager.laundry.R;

/**
 * Created by User on 15-Nov-18.
 */

public class Notification extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;

    public Notification() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        activity = getActivity();
        initializeData();

        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*landing_search_filter_language_recycleView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                // TODO Auto-generated method stub
                if (newState < 1) {

                } else {

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // TODO Auto-generated method stub
                if (dy > 0) {

                } else {

                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/

    }

    /**
     * This method creates an ArrayList that has Church Notification model class objects
     */
    private void initializeData() {
     /*   languages_events = new ArrayList<>();
      *//*  filter_prefs = getActivity().getSharedPreferences(Config.FILTER_PREFS, MODE_PRIVATE);
        ArrayList<String> languagesList = new ArrayList<>(filter_prefs.getStringSet("languages_Set", new HashSet<String>()));
        if (!languagesList.isEmpty()){
            for (int i=0; i<languagesList.size(); i++){
                languages_events.add(new Landing_FilterSearch_Languages(String.valueOf(i+1), languagesList.get(i), false));
            }
        }*//*

        languages_events.add(new HomePage("1","English", false));
        languages_events.add(new HomePage("2","Malayalam", false));
        languages_events.add(new HomePage("3","Tamil", false));
        languages_events.add(new HomePage("4","Kannada", false));
        languages_events.add(new HomePage("5","Hindi", false));
        languages_events.add(new HomePage("6","Telugu", false));*/

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

}