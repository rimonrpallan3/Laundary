package com.voyager.laundry.fragment.women.model;

/**
 * Created by User on 11-Dec-18.
 */

public class Women {
    int dress;
    String menheading;
    String subheading;
    String intialAmt;


    public Women(int dress, String menheading, String subheading, String intialAmt) {
            this.dress = dress;
        this.menheading = menheading;
        this.subheading = subheading;
        this.intialAmt = intialAmt;
    }


    public int getDress() {
        return dress;
    }

    public void setDress(int dress) {
        this.dress = dress;
    }

    public String getMenheading() {
        return menheading;
    }

    public void setMenheading(String menheading) {
        this.menheading = menheading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getIntialAmt() {
        return intialAmt;
    }

    public void setIntialAmt(String intialAmt) {
        this.intialAmt = intialAmt;
    }
}
