package com.voyager.laundry.fragment.homepage.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 22-Nov-18.
 */

public class ServiceItems implements Parcelable {
    public String imageView;
    public String heading;
    public String subHeading;
    public int serviceImage;

    public ServiceItems(String imageView, String heading, String subHeading, int serviceImage) {
        this.imageView = imageView;
        this.heading = heading;
        this.subHeading = subHeading;
        this.serviceImage = serviceImage;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public int getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(int serviceImage) {
        this.serviceImage = serviceImage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageView);
        dest.writeString(this.heading);
        dest.writeString(this.subHeading);
        dest.writeInt(this.serviceImage);
    }

    protected ServiceItems(Parcel in) {
        this.imageView = in.readString();
        this.heading = in.readString();
        this.subHeading = in.readString();
        this.serviceImage = in.readInt();
    }

    public static final Creator<ServiceItems> CREATOR = new Creator<ServiceItems>() {
        @Override
        public ServiceItems createFromParcel(Parcel source) {
            return new ServiceItems(source);
        }

        @Override
        public ServiceItems[] newArray(int size) {
            return new ServiceItems[size];
        }
    };
}
