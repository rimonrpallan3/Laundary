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
        dest.writeString(this.notificationHeading);
        dest.writeString(this.notificationSubHeading);
        dest.writeString(this.notificationTime);
        dest.writeInt(this.notificationImg);
    }

    protected NotificationList(Parcel in) {
        this.notificationHeading = in.readString();
        this.notificationSubHeading = in.readString();
        this.notificationTime = in.readString();
        this.notificationImg = in.readInt();
    }

    public static final Creator<NotificationList> CREATOR = new Creator<NotificationList>() {
        @Override
        public NotificationList createFromParcel(Parcel source) {
            return new NotificationList(source);
        }

        @Override
        public NotificationList[] newArray(int size) {
            return new NotificationList[size];
        }
    };
}
