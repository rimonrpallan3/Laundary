package com.voyager.laundry.fragment.homepage;

import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.adapter.OrderListAdapter;
import com.voyager.laundry.fragment.homepage.adapter.RecycleViewSlidingAdapter;
import com.voyager.laundry.fragment.homepage.adapter.RecyclerViewHorizontalListAdapter;
import com.voyager.laundry.fragment.homepage.adapter.SlidingImage_Adapter;
import com.voyager.laundry.fragment.homepage.model.OrderList;
import com.voyager.laundry.fragment.homepage.model.ServiceItems;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 14-Nov-18.
 */

public class HomePage extends Fragment implements
        View.OnClickListener {

    // Toolbar toolbar_faith_landing;
    RecyclerView landing_search_filter_language_recycleView;

    private Activity activity;
    SharedPreferences filter_prefs;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.quickwash_banner,R.drawable.quickwash_banner,R.drawable.quickwash_banner,R.drawable.quickwash_banner};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    DiscreteScrollView scrollView;
    private List<ServiceItems> serviceItems = new ArrayList<>();
    private RecyclerView rvHorizontalView;
    private RecyclerView rvBannerList;
    private RecyclerView rvOrderList;
    private OrderListAdapter orderListAdapter;
    private List<OrderList> orderLists = new ArrayList<>();
    private RecyclerViewHorizontalListAdapter serviceListAdapter;
    TextView tvOrderCount;
    RecycleViewSlidingAdapter recycleViewSlidingAdapter;


    public HomePage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        init(rootView);
        horizontalList(rootView);
        orderVerticalList(rootView);
        return rootView;
    }



    private  void horizontalList(View rootView){
        rvHorizontalView = rootView.findViewById(R.id.rvHorizontalView);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        serviceListAdapter = new RecyclerViewHorizontalListAdapter(serviceItems, activity);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        rvHorizontalView.setLayoutManager(horizontalLayoutManager);
        rvHorizontalView.setAdapter(serviceListAdapter);
        populateServiceList();
    }


    private void orderVerticalList(View rootView){
        tvOrderCount = rootView.findViewById(R.id.tvOrderCount);
        rvOrderList = rootView.findViewById(R.id.rvOrderList);
        // add a divider after each item for more clarity
        //rvHorizontalView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL));
        orderListAdapter = new OrderListAdapter(orderLists);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvOrderList.setLayoutManager(horizontalLayoutManager);
        rvOrderList.setAdapter(orderListAdapter);
        rvOrderList.setLayoutFrozen(true);
        populateOrderList();
    }

    private void populateServiceList(){
        ServiceItems potato = new ServiceItems("https://www.gstatic.com/webp/gallery/4.sm.jpg","Wash And Fold","Min 12 Hours", R.drawable.washing_machine);
        ServiceItems onion = new ServiceItems("https://www.gstatic.com/webp/gallery/4.sm.jpg","Wash And Lorn","Min 6 Hours", R.drawable.iron_box);
        ServiceItems cabbage = new ServiceItems("https://www.gstatic.com/webp/gallery/4.sm.jpg","Dry Clean","Min 24 Hours", R.drawable.dry_clean);
        serviceItems.add(potato);
        serviceItems.add(onion);
        serviceItems.add(cabbage);
        serviceListAdapter.notifyDataSetChanged();
    }

    private void populateOrderList(){
        OrderList firstOrder = new OrderList("https://www.gstatic.com/webp/gallery/4.sm.jpg",
                1,"Confirmed" ,
                "12","25 june, 2018",R.drawable.progress1__1_);
        OrderList secondOrder = new OrderList("https://www.gstatic.com/webp/gallery/4.sm.jpg",
                2,"Picked up" ,"25","25 june, 2018",R.drawable.progress2__1_);
        OrderList thirdOrder = new OrderList("https://www.gstatic.com/webp/gallery/4.sm.jpg",
                3,"In process" ,"17","25 june, 2018",R.drawable.progress3__1_);
        OrderList fourthOrder = new OrderList("https://www.gstatic.com/webp/gallery/4.sm.jpg",
                4,"Dispatched" ,"12","25 june, 2018",R.drawable.progress4__1_);
        OrderList fifthOrder = new OrderList("https://www.gstatic.com/webp/gallery/4.sm.jpg",
                5,"Delivered" ,"10","25 june, 2018",R.drawable.progress5__1_);
        orderLists.add(firstOrder);
        orderLists.add(secondOrder);
        orderLists.add(thirdOrder);
        orderLists.add(fourthOrder);
        orderLists.add(fifthOrder);
        orderListAdapter.notifyDataSetChanged();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

    private void init(View rootView) {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(getActivity(),ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator)
                rootView.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                //finish();
                break;
            /*case R.id.btn_transition_time:
                DiscreteScrollViewOptions.configureTransitionTime(cityPicker);
                break;
            case R.id.btn_smooth_scroll:
                DiscreteScrollViewOptions.smoothScrollToUserSelectedPosition(cityPicker, v);
                break;*/
        }
    }




}