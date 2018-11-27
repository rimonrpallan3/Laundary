package com.voyager.laundry.activity.registerpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.voyager.laundry.MainActivity;
import com.voyager.laundry.R;
import com.voyager.laundry.activity.landing.Landing;
import com.voyager.laundry.common.Helper;
import com.voyager.laundry.common.NetworkDetector;
import com.voyager.laundry.costom.CircleImageView;
import com.voyager.laundry.activity.registerpage.model.UserDetails;
import com.voyager.laundry.activity.registerpage.presenter.IRegisterFetcher;
import com.voyager.laundry.activity.registerpage.view.IRegisterView;

import static com.voyager.laundry.common.Helper.REQUEST_REGISTERED;


/**
 * Created by User on 8/23/2017.
 */

public class RegisterPage extends AppCompatActivity implements IRegisterView {

    private AppCompatEditText etName;
    private AppCompatEditText etEmail;
    private AppCompatEditText etCPass;
    private AppCompatEditText etCnfPass;
    private AppCompatEditText etNo;
    ImageView ivBackbtn;
    private Button btnRegister;
    CircleImageView profileImg;
    IRegisterFetcher iRegisterFetcher;


    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    String country ="";
    String zipCode ="";
    String PhoneNo ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        //find viewgit init
        profileImg = (CircleImageView) this.findViewById(R.id.profileImg);
        etName = (AppCompatEditText) this.findViewById(R.id.etName);
        etEmail = (AppCompatEditText) this.findViewById(R.id.etEmail);
        etCPass = (AppCompatEditText) this.findViewById(R.id.etCPass);
        etCnfPass = (AppCompatEditText) this.findViewById(R.id.etCnfPass);
        etNo = (AppCompatEditText) this.findViewById(R.id.etNo);
        btnRegister = (Button) this.findViewById(R.id.btnRegister);
        ivBackbtn =  this.findViewById(R.id.ivBackbtn);
        Bundle bundle = getIntent().getExtras();

        //init
        sharedPrefs = getSharedPreferences(Helper.UserDetails,
                Context.MODE_PRIVATE);
        editor = sharedPrefs.edit();
       // iRegisterFetcher = new RegisterPresenter(this,sharedPrefs,editor);




        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    public void btnRegister(View v){
        if(NetworkDetector.haveNetworkConnection(this)){
            //Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network_available), Snackbar.LENGTH_SHORT).show();
            /*btnRegister.setEnabled(false);
            iRegisterFetcher.doRegister(etName.getText().toString(),
                    etCPass.getText().toString(),
                    etCnfPass.getText().toString(),
                    etEmail.getText().toString(),
                    etNo.getText().toString(),
                    etNo.getText().toString(),
                    country.toString())*/;
            Intent intent = new Intent(this, Landing.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            setResult(REQUEST_REGISTERED);
            startActivity(intent);
            finish();
        }else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();

        }
    }

    public void ivBackbtn(View v){
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // outState.putParcelable(Helper.UserDetails,);
    }

    @Override
    public void onRegister(Boolean result, int code) {
        /*edtFullName.setEnabled(true);
        edtPassword.setEnabled(true);
        edtRetypePassword.setEnabled(true);
        txtViewPhoneNo.setEnabled(true);
        edtCity.setEnabled(true);
        //edtCPR.setEnabled(true);
        if (result) {
        } else {
            btnRegister.setEnabled(true);
            switch (code) {
                case -1:
                    Toast.makeText(this, "Please fill all the fields, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(this, "Please fill a valid First Name, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(this, "Please fill a valid Password, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -4:
                    Toast.makeText(this, "Please type the Same Password, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -5:
                    Toast.makeText(this, "Please fill a valid email Address, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -6:
                    Toast.makeText(this, "Please fill a valid Phone No, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -7:
                    Toast.makeText(this, "Please fill a valid City Name, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -8:
                    Toast.makeText(this, "Please fill a valid Country, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Please try Again Later, code = " + code, Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    @Override
    public void onRegistered(Boolean result, int code) {
       /* System.out.println("-----onRegistered second Please see, code = " + code + ", result: " + result);
        if (result) {
            System.out.println("------- inside onRegistered first Please see, code = " + code + ", result: " + result);
            //Toast.makeText(this, "-----onRegistered second Please see, code = " + code + ", result: " + result, Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //re-enable the button
                    btnRegister.setEnabled(true);
                }
            }, 4000);
            iRegisterFetcher.onRegisteredSucuess();
        } else {
            edtFullName.setEnabled(true);
            edtPassword.setEnabled(true);
            edtEmailAddress.setEnabled(true);
            txtViewPhoneNo.setEnabled(true);
            edtCity.setEnabled(true);
            btnRegister.setEnabled(true);
            switch (code) {
                case -9:
                    Toast.makeText(this, "Please Correct the Required fields, code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                case -77:
                    Toast.makeText(this, "SomeThing went Wrong on our end Please try after some time , code = " + code, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Please try Again Later, code = " + code, Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    @Override
    public void sendPParcelableObj(UserDetails userDetails) {
        /*System.out.println("Name : "+userDetails.getFName());
        Intent intent = new Intent(this, LandingPage.class);
        intent.putExtra("UserDetails", userDetails);
        intent.putExtra("LoginDone", "done");
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        setResult(REQUEST_REGISTERED);
        startActivity(intent);
        finish();*/
    }


}
