package com.voyager.laundry.fragment.kids;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.kids.adapter.KidsListAdapter;
import com.voyager.laundry.fragment.kids.model.Kids;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11-Dec-18.
 */

public class KidsPage extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;
    KidsListAdapter kidsListAdapter;
    private List<Kids> kidsList = new ArrayList<>();
    private RecyclerView rvkids;

    public KidsPage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_kids, container, false);
        activity = getActivity();
        kidsVerticalList(rootView);
        return rootView;
    }

    private void kidsVerticalList(View rootView) {
        rvkids = rootView.findViewById(R.id.rvkids);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        kidsListAdapter = new KidsListAdapter(kidsList,activity);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvkids.setLayoutManager(horizontalLayoutManager);
        rvkids.setAdapter(kidsListAdapter);
        populateOrderList();

    }

    private void populateOrderList() {
        Kids firstOrder = new Kids(R.drawable.t_shirt,
                "T- Shirt ", "Newfree3", "2 BD");
        kidsList.add(firstOrder);
        kidsListAdapter.notifyDataSetChanged();
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
        });
*/
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