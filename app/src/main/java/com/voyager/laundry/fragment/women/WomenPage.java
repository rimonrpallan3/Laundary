package com.voyager.laundry.fragment.women;

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
import com.voyager.laundry.fragment.menpage.adapter.MenListAdapter;
import com.voyager.laundry.fragment.menpage.model.Men;
import com.voyager.laundry.fragment.women.adapter.WomenListAdapter;
import com.voyager.laundry.fragment.women.model.Women;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11-Dec-18.
 */

public class WomenPage extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;
    WomenListAdapter womenListAdapter;
    private List<Women> womenList = new ArrayList<>();
    private RecyclerView rvWomen;

    public WomenPage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_women, container, false);
        activity = getActivity();
        menVerticalList(rootView);
        return rootView;
    }

    private void menVerticalList(View rootView) {
        rvWomen = rootView.findViewById(R.id.rvWomen);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        womenListAdapter = new WomenListAdapter(womenList);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvWomen.setLayoutManager(horizontalLayoutManager);
        rvWomen.setAdapter(womenListAdapter);
        populateOrderList();

    }

    private void populateOrderList() {
        Women firstOrder = new Women(R.drawable.t_shirt,
                "T- Shirt ", "Newfree3", "2 BD");
        womenList.add(firstOrder);
        womenListAdapter.notifyDataSetChanged();
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