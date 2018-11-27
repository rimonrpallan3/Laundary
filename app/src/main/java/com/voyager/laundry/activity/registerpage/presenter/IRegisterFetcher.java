package com.voyager.laundry.activity.registerpage.presenter;

/**
 * Created by User on 8/30/2017.
 */

public interface IRegisterFetcher {
    void doRegister(String FullName, String Password, String RetypePassword, String email, String phno, String city, String country);
    void onRegisteredSucuess();
}
