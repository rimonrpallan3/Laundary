package com.voyager.laundry.activity.datetime.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.voyager.laundry.fragment.deliverydate.DeliveryDate;
import com.voyager.laundry.fragment.kids.KidsPage;
import com.voyager.laundry.fragment.menpage.MenPage;
import com.voyager.laundry.fragment.others.OthersPage;
import com.voyager.laundry.fragment.pickupdate.PickUpDate;
import com.voyager.laundry.fragment.women.WomenPage;


/**
 * Created by User on 14-Nov-18.
 */

public class DPTabViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    PickUpDate tab1;
    DeliveryDate tab2;

    Activity activity;

    public DPTabViewPagerAdapter(Activity activity, FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.activity = activity;
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new PickUpDate();
                return tab1;
            case 1:
                tab2 = new DeliveryDate();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab2;

            default:
                tab1 = new PickUpDate();
                return tab1;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }



}
