package com.voyager.laundry.fragment.pickupdate.model;

/**
 * Created by User on 12-Dec-18.
 */

public class Time {

    String time1;
    String time2;

    public Time(String time1, String time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}
