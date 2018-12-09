package com.voyager.laundry.activity.landing.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.voyager.laundry.fragment.homepage.HomePage;
import com.voyager.laundry.fragment.notification.Notification;
import com.voyager.laundry.fragment.couponpage.CouponPage;
import com.voyager.laundry.fragment.ProfilePage;

/**
 * Created by User on 14-Nov-18.
 */

public class TabViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    HomePage tab1;
    Notification tab2;
    CouponPage tab3;
    ProfilePage tab4;

    Activity activity;

    public TabViewPagerAdapter(Activity activity, FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.activity = activity;
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new HomePage();
                return tab1;
            case 1:
                tab2 = new Notification();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab2;
            case 2:
                tab3 = new CouponPage();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab3;
            case 3:
                tab4 = new ProfilePage();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab4;

            default:
                tab1 = new HomePage();
                return tab1;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }



}
