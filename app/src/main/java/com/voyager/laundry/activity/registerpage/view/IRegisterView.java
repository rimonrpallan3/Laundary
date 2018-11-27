package com.voyager.laundry.activity.registerpage.view;


import com.voyager.laundry.activity.registerpage.model.UserDetails;

/**
 * Created by User on 8/29/2017.
 */

public interface IRegisterView {
    void onRegister(Boolean result, int code);
    void onRegistered(Boolean result, int code);
    void sendPParcelableObj(UserDetails userDetails);
}
