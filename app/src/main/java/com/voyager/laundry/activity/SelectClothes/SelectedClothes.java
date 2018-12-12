package com.voyager.laundry.activity.SelectClothes;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.SelectClothes.adapter.ClothTabViewPagerAdapter;
import com.voyager.laundry.activity.landing.Landing;
import com.voyager.laundry.activity.review.ReviewOrder;
import com.voyager.laundry.common.Helper;

/**
 * Created by User on 11-Dec-18.
 */

public class SelectedClothes extends AppCompatActivity {


    private ClothTabViewPagerAdapter adapter2;

    ViewPager vpCloths;
    TabLayout tbCloths;
    FrameLayout flTab;
    LinearLayout llContBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cloth);

        llContBtn = findViewById(R.id.llContBtn);
        vpCloths = (ViewPager) findViewById(R.id.vpCloths);
        tbCloths = (TabLayout) findViewById(R.id.tbCloths);
        tbCloths.addTab(tbCloths.newTab().setText("MAN"));
        tbCloths.addTab(tbCloths.newTab().setText("WOMAN"));
        tbCloths.addTab(tbCloths.newTab().setText("KIDS"));
        tbCloths.addTab(tbCloths.newTab().setText("OTHER"));
       // tbCloths.setTabTextColors(R.color.tab_icon_color_unselect,R.color.default_green);
        //tbLanding.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_TOP);
        tbCloths.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter2 = new ClothTabViewPagerAdapter
                (this, getSupportFragmentManager(), tbCloths.getTabCount());
        vpCloths.setOffscreenPageLimit(4);
        vpCloths.setAdapter(adapter2);
        vpCloths.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tbCloths));
        //tbCloths.set(R.layout.badged_tab);
        tbCloths.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpCloths.setCurrentItem(tab.getPosition());
                //tab.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.default_green), PorterDuff.Mode.SRC_IN);
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
              //  tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.tab_icon_color_unselect), PorterDuff.Mode.SRC_IN);
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