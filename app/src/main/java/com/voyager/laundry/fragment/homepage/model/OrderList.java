package com.voyager.laundry.fragment.homepage.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 27-Nov-18.
 */

public class OrderList extends Item implements Parcelable {

    String itemOrderImg;
    Integer itemOrderNo;
    String  itemordeStatus;
    String itemOrderAmt;
    String itemOrderDate;
    int orderImg;
    public final static String TAG_NAME = "OrderList";


    public OrderList(){
        super();
        this.type = TAG_NAME;
    }


    public OrderList(String itemOrderImg, Integer itemOrderNo, String itemordeStatus, String itemOrderAmt, String itemOrderDate, int orderImg) {
        this.itemOrderImg = itemOrderImg;
        this.itemOrderNo = itemOrderNo;
        this.itemordeStatus = itemordeStatus;
        this.itemOrderAmt = itemOrderAmt;
        this.itemOrderDate = itemOrderDate;
        this.orderImg = orderImg;
        this.type = TAG_NAME;
    }

    public int getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public String getItemOrderImg() {
        return itemOrderImg;
    }

    public void setItemOrderImg(String itemOrderImg) {
        this.itemOrderImg = itemOrderImg;
    }

    public Integer getItemOrderNo() {
        return itemOrderNo;
    }

    public void setItemOrderNo(Integer itemOrderNo) {
        this.itemOrderNo = itemOrderNo;
    }

    public String getItemordeStatus() {
        return itemordeStatus;
    }

    public void setItemordeStatus(String itemordeStatus) {
        this.itemordeStatus = itemordeStatus;
    }

    public String getItemOrderAmt() {
        return itemOrderAmt;
    }

    public void setItemOrderAmt(String itemOrderAmt) {
        this.itemOrderAmt = itemOrderAmt;
    }

    public String getItemOrderDate() {
        return itemOrderDate;
    }

    public void setItemOrderDate(String itemOrderDate) {
        this.itemOrderDate = itemOrderDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemOrderImg);
        dest.writeValue(this.itemOrderNo);
        dest.writeString(this.itemordeStatus);
        dest.writeString(this.itemOrderAmt);
        dest.writeString(this.itemOrderDate);
    }

    protected OrderList(Parcel in) {
        this.itemOrderImg = in.readString();
        this.itemOrderNo = (Integer) in.readValue(Integer.class.getClassLoader());
        this.itemordeStatus = in.readString();
        this.itemOrderAmt = in.readString();
        this.itemOrderDate = in.readString();
    }

    public static final Parcelable.Creator<OrderList> CREATOR = new Parcelable.Creator<OrderList>() {
        @Override
        public OrderList createFromParcel(Parcel source) {
            return new OrderList(source);
        }

        @Override
        public OrderList[] newArray(int size) {
            return new OrderList[size];
        }
    };
}
