package com.voyager.laundry.activity.address;

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
import com.voyager.laundry.activity.review.ReviewOrder;
import com.voyager.laundry.common.Helper;
import com.voyager.laundry.fragment.homeaddress.HomeAddress;
import com.voyager.laundry.fragment.officeaddress.OfficeAddress;
import com.voyager.laundry.fragment.othersaddress.OthersAddress;

/**
 * Created by User on 12-Dec-18.
 */

public class PickAddress extends AppCompatActivity {

    Activity activity;
    Bundle bundle;
    ImageView ivPointer1;
    ImageView ivPointer2;
    ImageView ivPointer3;
    LinearLayout llContBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_address);
        activity = this;
        bundle = new Bundle();
        ivPointer1 = findViewById(R.id.ivPointer1);
        ivPointer2 = findViewById(R.id.ivPointer2);
        ivPointer3 = findViewById(R.id.ivPointer3);
        llContBtn = findViewById(R.id.llContBtn);

        ivPointer1.setVisibility(View.VISIBLE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.GONE);
        HomeAddress homeTabFragment = new HomeAddress();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, homeTabFragment);
        homeTabFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        llContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DateTime.class);
                startActivity(intent);
            }
        });
    }

    public void ivBackbtn(View v){
        finish();
    }


    public void homeClick(View v){
        ivPointer1.setVisibility(View.VISIBLE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_SHORT).show();
        HomeAddress homeTabFragment = new HomeAddress();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, homeTabFragment);
        homeTabFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void officeClick(View v){
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.VISIBLE);
        ivPointer3.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Office Selected", Toast.LENGTH_SHORT).show();
        OfficeAddress earningTabFragment = new OfficeAddress();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, earningTabFragment);
        earningTabFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void othersClick(View v){
        ivPointer1.setVisibility(View.GONE);
        ivPointer2.setVisibility(View.GONE);
        ivPointer3.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), "Others Selected", Toast.LENGTH_SHORT).show();
        OthersAddress ratingTabFragment = new OthersAddress();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, ratingTabFragment);
        ratingTabFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("Payment onActivityResult");
      /*  if(data!=null){
            String orderConfirm = data.getStringExtra("orderConfirm");
            if(orderConfirm!=null){
                Intent previousScreen = new Intent(getApplicationContext(), DateTime.class);
                //Sending the data to Activity_A
                previousScreen.putExtra("orderConfirm","true");
                setResult(1000, previousScreen);
                finish();
            }
        }*/

        if (requestCode == Helper.REQUEST_LOGEDIN) {
            try{
                if(data!=null) {
                    String LoginDone = (String) data.getExtras().getString("orderConfirm");
                    if (LoginDone != null) {
                        System.out.println("onActivityResult orderConfirm has ben called ");
                        Intent intent = getIntent();
                        intent.putExtra("orderConfirm","true");
                        setResult(Helper.REQUEST_LOGEDIN);
                        //intent.putExtra("orderConfirm","true");
                        //startActivityForResult(intent, Helper.REQUEST_LOGEDIN);
                        finish();
                    }
                }else {
                    System.out.println("LoginSignUpPage  onActivityResult null ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }else if (requestCode == Helper.REQUEST_REGISTERED){
            System.out.println("onActivityResult REQUEST_REGISTERED has ben called ");
            finish();
        }

    }



}