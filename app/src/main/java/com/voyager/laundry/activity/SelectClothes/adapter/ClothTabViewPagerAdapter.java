package com.voyager.laundry.activity.SelectClothes.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.voyager.laundry.fragment.kids.KidsPage;
import com.voyager.laundry.fragment.menpage.MenPage;
import com.voyager.laundry.fragment.others.OthersPage;
import com.voyager.laundry.fragment.women.WomenPage;


/**
 * Created by User on 14-Nov-18.
 */

public class ClothTabViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    MenPage tab1;
    WomenPage tab2;
    KidsPage tab3;
    OthersPage tab4;

    Activity activity;

    public ClothTabViewPagerAdapter(Activity activity, FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.activity = activity;
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new MenPage();
                return tab1;
            case 1:
                tab2 = new WomenPage();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab2;
            case 2:
                tab3 = new KidsPage();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab3;
            case 3:
                tab4 = new OthersPage();
                //((MainActivity) activity).setLandingFragment(tab2);
                return tab4;

            default:
                tab1 = new MenPage();
                return tab1;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }



}
