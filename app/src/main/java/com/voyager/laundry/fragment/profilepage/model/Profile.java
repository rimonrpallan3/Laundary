package com.voyager.laundry.fragment.profilepage.model;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by User on 10-Dec-18.
 */

public class Profile {

    private boolean enabled=true;
    private int ID;
    private String Name;
    private String Discription;
    private String ImageUrl;
    private int ImageId;
    protected String type;
    private int notify;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private MaterialDrawableBuilder.IconValue iconDraw;

    public MaterialDrawableBuilder.IconValue getIconDraw() {
        return iconDraw;
    }

    public void setIconDraw(MaterialDrawableBuilder.IconValue iconDraw) {
        this.iconDraw = iconDraw;
    }

    public int getNotify() {
        return notify;
    }

    public void setNotify(int notify) {
        this.notify = notify;
    }

    public final static String TAG_NAME = "item";

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public Profile(){this.type=TAG_NAME;}

    public String getImageUrl() {return ImageUrl;}

    public void setImageUrl(String imageUrl) {ImageUrl = imageUrl;}

    public int getImageId() { return ImageId;}

    public void setImageId(int imageId) {ImageId = imageId;}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
