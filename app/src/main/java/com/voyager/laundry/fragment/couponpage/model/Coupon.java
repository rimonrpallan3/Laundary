package com.voyager.laundry.fragment.couponpage.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 10-Dec-18.
 */

public class Coupon implements Parcelable {

    String couponHeading;
    String couponSubHeading;
    String couponBtnTxt;


    public Coupon(String couponHeading, String couponSubHeading, String couponBtnTxt) {
        this.couponHeading = couponHeading;
        this.couponSubHeading = couponSubHeading;
        this.couponBtnTxt = couponBtnTxt;
    }

    public String getCouponHeading() {
        return couponHeading;
    }

    public void setCouponHeading(String couponHeading) {
        this.couponHeading = couponHeading;
    }

    public String getCouponSubHeading() {
        return couponSubHeading;
    }

    public void setCouponSubHeading(String couponSubHeading) {
        this.couponSubHeading = couponSubHeading;
    }

    public String getCouponBtnTxt() {
        return couponBtnTxt;
    }

    public void setCouponBtnTxt(String couponBtnTxt) {
        this.couponBtnTxt = couponBtnTxt;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.couponHeading);
        dest.writeString(this.couponSubHeading);
        dest.writeString(this.couponBtnTxt);
    }

    public Coupon() {
    }

    protected Coupon(Parcel in) {
        this.couponHeading = in.readString();
        this.couponSubHeading = in.readString();
        this.couponBtnTxt = in.readString();
    }

    public static final Creator<Coupon> CREATOR = new Creator<Coupon>() {
        @Override
        public Coupon createFromParcel(Parcel source) {
            return new Coupon(source);
        }

        @Override
        public Coupon[] newArray(int size) {
            return new Coupon[size];
        }
    };
}
