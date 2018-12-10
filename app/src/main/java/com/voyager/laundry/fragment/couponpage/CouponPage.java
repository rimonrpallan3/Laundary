package com.voyager.laundry.fragment.couponpage;

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
import com.voyager.laundry.fragment.couponpage.adapter.CouponListAdapter;
import com.voyager.laundry.fragment.couponpage.model.Coupon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15-Nov-18.
 */

public class CouponPage extends Fragment {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;
    CouponListAdapter couponListAdapter;
    private List<Coupon> couponList = new ArrayList<>();
    private RecyclerView rvCouponList;

    public CouponPage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_coupon, container, false);
        activity = getActivity();
        couponVerticalList(rootView);
        return rootView;
    }

    private void couponVerticalList(View rootView){
        rvCouponList = rootView.findViewById(R.id.rvCouponList);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        couponListAdapter = new CouponListAdapter(couponList);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvCouponList.setLayoutManager(horizontalLayoutManager);
        rvCouponList.setAdapter(couponListAdapter);
        populateOrderList();

    }

    private void populateOrderList(){
        Coupon firstOrder = new Coupon("New user ? First Wash Free!!",
                "oh! You're new user ? order and get your first washing up to 3 cloths are free you need to register  ","Newfree3");
        Coupon secondOrder = new Coupon("New user ? First Wash Free!!",
                "oh! You're new user ? order and get your first washing up to 3 cloths are free you need to register  ","Newfree3");
        Coupon thirdOrder = new Coupon("New user ? First Wash Free!!",
                "oh! You're new user ? order and get your first washing up to 3 cloths are free you need to register  ","Newfree3");
        Coupon fourthOrder = new Coupon("New user ? First Wash Free!!",
                "oh! You're new user ? order and get your first washing up to 3 cloths are free you need to register  ","Newfree3");
        Coupon fifthOrder = new Coupon("New user ? First Wash Free!!",
                "oh! You're new user ? order and get your first washing up to 3 cloths are free you need to register  ","Newfree3");
        couponList.add(firstOrder);
        couponList.add(secondOrder);
        couponList.add(thirdOrder);
        couponList.add(fourthOrder);
        couponList.add(fifthOrder);
        couponListAdapter.notifyDataSetChanged();
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