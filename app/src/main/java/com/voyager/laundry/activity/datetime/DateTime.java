package com.voyager.laundry.activity.datetime;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.datetime.adapter.DPTabViewPagerAdapter;
import com.voyager.laundry.activity.review.ReviewOrder;
import com.voyager.laundry.common.Helper;

/**
 * Created by User on 12-Dec-18.
 */

public class DateTime extends AppCompatActivity {


    private DPTabViewPagerAdapter adapter2;

    ViewPager vpDP;
    TabLayout tbDP;
    FrameLayout flTab;
    LinearLayout llContBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        llContBtn = findViewById(R.id.llContBtn);
        vpDP = (ViewPager) findViewById(R.id.vpDP);
        tbDP = (TabLayout) findViewById(R.id.tbDP);
        LayoutInflater layoutInflater = getLayoutInflater();
        View tabOne = layoutInflater.inflate(R.layout.custom_tab, null, false);
        final ImageView ivCustomTab = (ImageView) tabOne.findViewById(R.id.ivCustomTab);
        final TextView tvCustomTab = (TextView) tabOne.findViewById(R.id.tvCustomTab);
        ivCustomTab.setImageResource(R.drawable.pickup);
        tvCustomTab.setText("PICK UP");
        View tabTwo = layoutInflater.inflate(R.layout.custom_tab, null, false);
        ImageView ivCustomTab2 = (ImageView) tabTwo.findViewById(R.id.ivCustomTab);
        TextView tvCustomTab2 = (TextView) tabTwo.findViewById(R.id.tvCustomTab);
        ivCustomTab2.setImageResource(R.drawable.delivery_inactive);
        tvCustomTab2.setText("DELIVERY");
        tbDP.addTab(tbDP.newTab().setCustomView(tabOne));
        tbDP.addTab(tbDP.newTab().setCustomView(tabTwo));
        tbDP.setTabGravity(TabLayout.GRAVITY_CENTER);
        adapter2 = new DPTabViewPagerAdapter
                (this, getSupportFragmentManager(), tbDP.getTabCount());
        vpDP.setOffscreenPageLimit(4);
        vpDP.setAdapter(adapter2);
        vpDP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tbDP));
        final ImageView ivCustomTab0 = tbDP.getTabAt(0).getCustomView().findViewById(R.id.ivCustomTab);
        final TextView tvCustomTab0 = tbDP.getTabAt(0).getCustomView().findViewById(R.id.tvCustomTab);

        final ImageView ivCustomTab1 = tbDP.getTabAt(1).getCustomView().findViewById(R.id.ivCustomTab);
        final TextView tvCustomTab1 = tbDP.getTabAt(1).getCustomView().findViewById(R.id.tvCustomTab);
        //tbCloths.set(R.layout.badged_tab);
        tbDP.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpDP.setCurrentItem(tab.getPosition());
               // tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.default_green), PorterDuff.Mode.SRC_IN);
                if (tab.getPosition() == 1) {
                    //faith_search_edit_text.setAdapter(suggestionAdapter);
                    ivCustomTab0.setImageResource(R.drawable.pickup_inactive);
                    tvCustomTab0.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.tab_icon_color_unselect));
                    ivCustomTab1.setImageResource(R.drawable.delivery);
                    tvCustomTab1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.default_green));

                }
                if (tab.getPosition() == 0) {
                    ivCustomTab0.setImageResource(R.drawable.pickup);
                    tvCustomTab0.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.default_green));
                    ivCustomTab1.setImageResource(R.drawable.delivery_inactive);
                    tvCustomTab1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.tab_icon_color_unselect));

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                 // tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.tab_icon_color_unselect), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        llContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewOrder.class);
                startActivity(intent);
            }
        });
    }

    public void ivBackbtn(View v){
        finish();
    }

}