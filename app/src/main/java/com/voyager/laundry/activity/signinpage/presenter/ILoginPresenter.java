package com.voyager.laundry.activity.signinpage.presenter;


/**
 * Created by kaede on 2015/10/12.
 */
public interface ILoginPresenter {
	void clear();
	void doLogin(String emailPhno, String passwd, String fireBaseToken);
	void onLoginSucuess();
}
