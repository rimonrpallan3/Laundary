package com.voyager.laundry.activity.payment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.datetime.DateTime;
import com.voyager.laundry.activity.orderpage.OrderConfirm;
import com.voyager.laundry.fragment.carddetials.CardDetails;
import com.voyager.laundry.fragment.homeaddress.HomeAddress;
import com.voyager.laundry.fragment.officeaddress.OfficeAddress;
import com.voyager.laundry.fragment.othersaddress.OthersAddress;

/**
 * Created by User on 12-Dec-18.
 */

public class Payment extends AppCompatActivity {

    Activity activity;
    Bundle bundle;
    ImageView ivPointer1;
    ImageView ivPointer2;
    ImageView ivPointer3;
    LinearLayout llContBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        activity = this;
        bundle = new Bundle();
        ivPointer1 = findViewById(R.id.ivPointer1);
        ivPointer2 = findViewById(R.id.ivPointer2);
        ivPointer3 = findViewById(R.id.ivPointer3);
        llContBtn = findViewById(R.id.llContBtn);

        ivPointer1.setVisibility(View.VISIBLE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.GONE);
        CardDetails cardDetails = new CardDetails();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, cardDetails);
        cardDetails.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        llContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderConfirm.class);
                startActivity(intent);
            }
        });
    }

    public void ivBackbtn(View v){
        finish();
    }


    public void debitClick(View v){
        ivPointer1.setVisibility(View.VISIBLE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Debit Card Selected", Toast.LENGTH_SHORT).show();
        CardDetails cardDetails = new CardDetails();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, cardDetails);
        cardDetails.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void creditClick(View v){
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.VISIBLE);
        ivPointer3.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Credit Card Selected", Toast.LENGTH_SHORT).show();
        CardDetails cardDetails = new CardDetails();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, cardDetails);
        cardDetails.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CODClick(View v){
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), "COD Selected", Toast.LENGTH_SHORT).show();
        OthersAddress ratingTabFragment = new OthersAddress();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, ratingTabFragment);
        ratingTabFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




}