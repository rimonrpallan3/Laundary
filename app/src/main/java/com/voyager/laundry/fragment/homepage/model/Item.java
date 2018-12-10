package com.voyager.laundry.fragment.homepage.model;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by User on 19-Nov-18.
 */

public class Item {

    private int id;
    private String name;
    private String price;
    private int image;

    protected String type;
    private boolean enabled=true;

    private int notify;
    private MaterialDrawableBuilder.IconValue iconDraw;

    public Item() {
    }

    public Item(int id, String name, String price, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getNotify() {
        return notify;
    }

    public void setNotify(int notify) {
        this.notify = notify;
    }

    public MaterialDrawableBuilder.IconValue getIconDraw() {
        return iconDraw;
    }

    public void setIconDraw(MaterialDrawableBuilder.IconValue iconDraw) {
        this.iconDraw = iconDraw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
