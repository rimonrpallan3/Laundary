package com.voyager.laundry.fragment.notification.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 27-Nov-18.
 */

public class NotificationList implements Parcelable {


    String  notificationHeading;
    String notificationSubHeading;
    String notificationTime;
    int notificationImg;

    public NotificationList(String notificationHeading, String notificationSubHeading, String notificationTime, int notificationImg) {
        this.notificationHeading = notificationHeading;
        this.notificationSubHeading = notificationSubHeading;
        this.notificationTime = notificationTime;
        this.notificationImg = notificationImg;
    }


    public String getNotificationHeading() {
        return notificationHeading;
    }

    public void setNotificationHeading(String notificationHeading) {
        this.notificationHeading = notificationHeading;
    }

    public String getNotificationSubHeading() {
        return notificationSubHeading;
    }

    public void setNotificationSubHeading(String notificationSubHeading) {
        this.notificationSubHeading = notificationSubHeading;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public int getNotificationImg() {
        return notificationImg;
    }

    public void setNotificationImg(int notificationImg) {
        this.notificationImg = notificationImg;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
