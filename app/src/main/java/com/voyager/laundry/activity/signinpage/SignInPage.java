package com.voyager.laundry.activity.signinpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.laundry.MainActivity;
import com.voyager.laundry.R;
import com.voyager.laundry.activity.landing.Landing;
import com.voyager.laundry.common.Helper;
import com.voyager.laundry.common.NetworkDetector;
import com.voyager.laundry.activity.forgotpass.ForgotPassword;
import com.voyager.laundry.activity.registerpage.RegisterPage;
import com.voyager.laundry.activity.registerpage.model.UserDetails;
import com.voyager.laundry.activity.signinpage.presenter.ILoginPresenter;
import com.voyager.laundry.activity.signinpage.presenter.SignInPresenter;
import com.voyager.laundry.activity.signinpage.view.ISignInView;


/**
 * Created by User on 8/23/2017.
 */

public class SignInPage extends AppCompatActivity implements ISignInView {

    private EditText edtEmailPhno;
    private EditText edtPswd;
    private TextView tvForgotPswd;
    private Button btnSignIn;

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;

    ILoginPresenter iLoginPresenter;
    String fireBaseToken = "";
    private AppCompatEditText etEmail;
    private AppCompatEditText etCPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //fireBaseToken = FirebaseInstanceId.getInstance().getToken();
        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();


        //find view
        etEmail = this.findViewById(R.id.etEmail);
        etCPass = this.findViewById(R.id.etCPass);
        tvForgotPswd = this.findViewById(R.id.tvForgotPswd);
        btnSignIn = (Button) this.findViewById(R.id.btnSignIn);

        //init
        iLoginPresenter = new SignInPresenter(this, sharedPrefs, editor, this);
    }

    public void btnSignIn(View v) {
        Helper.hideKeyboard(this);
        if (NetworkDetector.haveNetworkConnection(this)) {
            /*//Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network_available), Snackbar.LENGTH_SHORT).show();
            iLoginPresenter.setProgressBarVisiblity(View.VISIBLE);
            btnSignIn.setEnabled(false);
            iLoginPresenter.doLogin(edtEmailPhno.getText().toString(), edtPswd.getText().toString(), fireBaseToken);*/

            Intent intent = new Intent(this, Landing.class);
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();

        }

    }

    public void btnSignUp(View v) {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
        //finish();
    }

    public void tvForgotPswd(View v) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onClearText() {
        edtEmailPhno.setText("");
        edtPswd.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        edtEmailPhno.setEnabled(true);
        edtPswd.setEnabled(true);
        if (result) {
        } else {
            Toast.makeText(this, "Please input Values, code = " + code, Toast.LENGTH_SHORT).show();
            btnSignIn.setEnabled(true);
            iLoginPresenter.clear();
        }
    }


    @Override
    public void onLoginResponse(Boolean result, int code) {
        edtEmailPhno.setEnabled(true);
        edtPswd.setEnabled(true);
        if (result) {
            iLoginPresenter.onLoginSucuess();
        } else {
            Toast.makeText(this, "Please input correct UserName and Password, code = " + code, Toast.LENGTH_SHORT).show();
            btnSignIn.setEnabled(true);
            iLoginPresenter.clear();
        }
    }

    @Override
    public void sendPParcelableObj(UserDetails userDetails) {
        System.out.println("UserDetails ----- FName: " + userDetails.getFName());
        Intent intent = new Intent(this, Landing.class);
        intent.putExtra("LoginDone", "Done");
        setResult(Helper.REQUEST_LOGEDIN, intent);
        intent.putExtra("UserDetails", userDetails);
        startActivity(intent);
        finish();
    }
}
