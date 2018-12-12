package com.voyager.laundry.activity.otppage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.landing.Landing;

import static com.voyager.laundry.common.Helper.REQUEST_REGISTERED;

/**
 * Created by User on 14-Nov-18.
 */

public class OTPPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_page);
    }

    public void ivBackbtn(View v){
        finish();
    }



    public void btnOTPSubmit(View v){
        Intent intent = new Intent(this, Landing.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        setResult(REQUEST_REGISTERED);
        startActivity(intent);
        finish();
    }
}
