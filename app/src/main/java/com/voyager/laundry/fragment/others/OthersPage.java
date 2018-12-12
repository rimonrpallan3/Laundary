package com.voyager.laundry.fragment.others;

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
import com.voyager.laundry.fragment.others.adapter.OthersListAdapter;
import com.voyager.laundry.fragment.others.model.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11-Dec-18.
 */

public class OthersPage extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;
    OthersListAdapter othersListAdapter;
    private List<Other> otherList = new ArrayList<>();
    private RecyclerView rvOther;

    public OthersPage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_other, container, false);
        activity = getActivity();
        kidsVerticalList(rootView);
        return rootView;
    }

    private void kidsVerticalList(View rootView) {
        rvOther = rootView.findViewById(R.id.rvOther);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        othersListAdapter = new OthersListAdapter(otherList);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvOther.setLayoutManager(horizontalLayoutManager);
        rvOther.setAdapter(othersListAdapter);
        populateOrderList();

    }

    private void populateOrderList() {
        Other firstOrder = new Other(R.drawable.t_shirt,
                "T- Shirt ", "Newfree3", "2 BD");
        otherList.add(firstOrder);
        othersListAdapter.notifyDataSetChanged();
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