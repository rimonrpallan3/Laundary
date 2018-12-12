package com.voyager.laundry.fragment.pickupdate;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.adapter.OrderListAdapter;
import com.voyager.laundry.fragment.homepage.adapter.RecycleViewSlidingAdapter;
import com.voyager.laundry.fragment.homepage.adapter.RecyclerViewHorizontalListAdapter;
import com.voyager.laundry.fragment.homepage.model.OrderList;
import com.voyager.laundry.fragment.homepage.model.ServiceItems;
import com.voyager.laundry.fragment.others.adapter.OthersListAdapter;
import com.voyager.laundry.fragment.others.model.Other;
import com.voyager.laundry.fragment.pickupdate.adapter.DateHorizontalListAdapter;
import com.voyager.laundry.fragment.pickupdate.adapter.TimeListAdapter;
import com.voyager.laundry.fragment.pickupdate.model.Date;
import com.voyager.laundry.fragment.pickupdate.model.Time;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12-Dec-18.
 */

public class PickUpDate extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;

    private List<Date> dateList = new ArrayList<>();
    private RecyclerView rvHorizontalView;
    private RecyclerView rvOrderList;
    private TimeListAdapter timeListAdapter;
    private List<Time> timeList = new ArrayList<>();
    private DateHorizontalListAdapter dateHorizontalListAdapter;
    TextView tvOrderCount;

    public PickUpDate() {
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_pick_date, container, false);
        activity = getActivity();
        horizontalList(rootView);
        orderVerticalList(rootView);
        return rootView;
    }

    private void orderVerticalList(View rootView){
        tvOrderCount = rootView.findViewById(R.id.tvOrderCount);
        rvOrderList = rootView.findViewById(R.id.rvOrderList);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        timeListAdapter = new TimeListAdapter(timeList);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvOrderList.setLayoutManager(horizontalLayoutManager);
        rvOrderList.setAdapter(timeListAdapter);
        rvOrderList.setLayoutFrozen(true);
        populateOrderList();
    }

    private void populateServiceList(){
        Date date1 = new Date("Today 12 Dec");
        Date date2 = new Date("Tomorrow 13 Dec");
        Date date3 = new Date("14 Dec");
        Date date4 = new Date("15 Dec");
        dateList.add(date1);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date4);
        dateHorizontalListAdapter.notifyDataSetChanged();
    }


    private void populateOrderList(){
        Time time1 = new Time(" 9:00 am to 10:00 am "," 10:00 am to 11:00 am");
        Time time2 = new Time(" 11:00 am to 12:00 pm "," 12:00 pm to 1:00 pm");
        Time time3 = new Time(" 1:00 pm to 2:00 pm "," 2:00 pm to 3:00 pm");
        Time time4 = new Time(" 3:00 pm to 4:00 pm "," 4:00 pm to 5:00 pm");
        timeList.add(time1);
        timeList.add(time2);
        timeList.add(time3);
        timeList.add(time4);
        timeListAdapter.notifyDataSetChanged();

    }


    private  void horizontalList(View rootView){
        rvHorizontalView = rootView.findViewById(R.id.rvHorizontalView);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        dateHorizontalListAdapter = new DateHorizontalListAdapter(dateList, activity);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        rvHorizontalView.setLayoutManager(horizontalLayoutManager);
        rvHorizontalView.setAdapter(dateHorizontalListAdapter);
        populateServiceList();
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