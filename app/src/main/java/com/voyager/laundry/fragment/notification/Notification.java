package com.voyager.laundry.fragment.notification;

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
import com.voyager.laundry.fragment.homepage.adapter.OrderListAdapter;
import com.voyager.laundry.fragment.homepage.model.OrderList;
import com.voyager.laundry.fragment.notification.adapter.NotificationListAdapter;
import com.voyager.laundry.fragment.notification.model.NotificationList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15-Nov-18.
 */

public class Notification extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;
    private List<NotificationList> notificationLists = new ArrayList<>();
    NotificationListAdapter notificationListAdapter;
    private RecyclerView rvNotificationList;

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
        notificationVerticalList(rootView);

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


    private void notificationVerticalList(View rootView){
        rvNotificationList = rootView.findViewById(R.id.rvNotificationList);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        notificationListAdapter = new NotificationListAdapter(notificationLists);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvNotificationList.setLayoutManager(horizontalLayoutManager);
        rvNotificationList.setAdapter(notificationListAdapter);
        populateOrderList();
    }

    private void populateOrderList(){
        NotificationList firstOrder = new NotificationList("Order Confirmed",
                "Your order No: 123456 is confirmed now. Pick up guy will reach on selected date and time","12:00 pm",R.drawable.order_confirmed);
        NotificationList secondOrder = new NotificationList("Order Ready to Deliver",
                "Your order No: 123456 is confirmed now. Pick up guy will reach on selected date and time","12:00 pm",R.drawable.order_confirmed);
        NotificationList thirdOrder = new NotificationList("Order Under Process",
                "Your order No: 123456 is confirmed now. Pick up guy will reach on selected date and time","12:00 pm",R.drawable.order_confirmed);
        NotificationList fourthOrder = new NotificationList("Order Delivered",
                "Your order No: 123456 is confirmed now. Pick up guy will reach on selected date and time","12:00 pm",R.drawable.order_confirmed);
        NotificationList fifthOrder = new NotificationList("Order Confirmed",
                "Your order No: 123456 is confirmed now. Pick up guy will reach on selected date and time","12:00 pm",R.drawable.order_confirmed);
        notificationLists.add(firstOrder);
        notificationLists.add(secondOrder);
        notificationLists.add(thirdOrder);
        notificationLists.add(fourthOrder);
        notificationLists.add(fifthOrder);
        notificationListAdapter.notifyDataSetChanged();
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