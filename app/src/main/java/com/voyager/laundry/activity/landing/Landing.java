package com.voyager.laundry.activity.landing;

import android.graphics.PorterDuff;
import android.os.Bundle;

import android.os.Handler;
import android.support.design.widget.TabLayout;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.viewpagerindicator.CirclePageIndicator;
import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.adapter.SlidingImage_Adapter;
import com.voyager.laundry.activity.landing.adapters.TabViewPagerAdapter;
import com.voyager.laundry.common.Helper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 14-Nov-18.
 */

public class Landing extends AppCompatActivity {


    private TabViewPagerAdapter adapter2;

    ViewPager vpLanding;
    TabLayout tbLanding;
    FrameLayout flTab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vpLanding = (ViewPager) findViewById(R.id.vpLanding);
        tbLanding = (TabLayout) findViewById(R.id.tbLanding);
        tbLanding.addTab(tbLanding.newTab().setIcon(R.drawable.mail));
        tbLanding.addTab(tbLanding.newTab().setIcon(R.drawable.phone));
        tbLanding.addTab(tbLanding.newTab().setIcon(R.drawable.lock));
        tbLanding.addTab(tbLanding.newTab().setIcon(R.drawable.name));
        //tbLanding.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_TOP);
        tbLanding.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter2 = new TabViewPagerAdapter
                (this, getSupportFragmentManager(), tbLanding.getTabCount());
        vpLanding.setOffscreenPageLimit(4);
        vpLanding.setAdapter(adapter2);
        vpLanding.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tbLanding));

        tbLanding.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpLanding.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.default_green), PorterDuff.Mode.SRC_IN);
                if (tab.getPosition() == 1) {
                    //faith_search_edit_text.setAdapter(suggestionAdapter);

                }
                if (tab.getPosition() == 0) {
                    try{
                        Helper.hideSoftKeyboard(getParent());
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.tab_icon_color_unselect), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}