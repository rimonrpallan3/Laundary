package com.voyager.laundry.fragment.homepage.model;

/**
 * Created by User on 10-Dec-18.
 */

public class HeaderItem extends Item {

    int bannerImg;

    public final static String TAG_NAME = "HeaderItem";


    public HeaderItem(){
        super();
        this.type = TAG_NAME;
    }


    public int getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(int bannerImg) {
        this.bannerImg = bannerImg;
    }
}
