package com.voyager.laundry.activity.signinpage.view;


import com.voyager.laundry.activity.registerpage.model.UserDetails;

/**
 * Created by User on 8/29/2017.
 */

public interface ISignInView {
    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onLoginResponse(Boolean result, int code);
    void sendPParcelableObj(UserDetails userDetails);
}
