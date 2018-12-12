package com.voyager.laundry.activity.review.model;

/**
 * Created by User on 11-Dec-18.
 */

public class ClothOrderedLsit {

    String clothCount;
    String type;
    String amt;


    public ClothOrderedLsit(String clothCount, String type, String amt) {
        this.clothCount = clothCount;
        this.type = type;
        this.amt = amt;
    }

    public String getClothCount() {
        return clothCount;
    }

    public void setClothCount(String clothCount) {
        this.clothCount = clothCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
}
