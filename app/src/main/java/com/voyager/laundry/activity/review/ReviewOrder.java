package com.voyager.laundry.activity.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.SelectClothes.SelectedClothes;
import com.voyager.laundry.activity.address.PickAddress;
import com.voyager.laundry.activity.landing.Landing;
import com.voyager.laundry.activity.review.adapter.ClothsWashListAdapter;
import com.voyager.laundry.activity.review.model.ClothOrderedLsit;
import com.voyager.laundry.common.Helper;
import com.voyager.laundry.fragment.homepage.model.OrderList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11-Dec-18.
 */

public class ReviewOrder extends AppCompatActivity {

    LinearLayout llContBtn;
    RecyclerView rvReviewOrder;
    ClothsWashListAdapter clothsWashListAdapter;
    List<ClothOrderedLsit> clothOrderedLsits= new ArrayList<>();
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);
        activity = this;
        llContBtn = findViewById(R.id.llContBtn);
        rvReviewOrder = findViewById(R.id.rvReviewOrder);

        clothsWashListAdapter = new ClothsWashListAdapter(clothOrderedLsits);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvReviewOrder.setLayoutManager(horizontalLayoutManager);
        rvReviewOrder.setAdapter(clothsWashListAdapter);
        rvReviewOrder.setLayoutFrozen(true);
        populateOrderList();

        llContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PickAddress.class);
                startActivity(intent);
            }
        });
    }

    private void populateOrderList(){
        ClothOrderedLsit firstOrder = new ClothOrderedLsit("2 x Shirt(Man)","Wash & Iron","5 BD");
        ClothOrderedLsit secondOrder = new ClothOrderedLsit("3 x Trouser(Man)","Wash & Iron","5 BD");
        ClothOrderedLsit thirdOrder = new ClothOrderedLsit("1 x Jeans(Man)","Wash & Fold","5 BD");
        ClothOrderedLsit fourthOrder = new ClothOrderedLsit("2 x T-Shirt(Women)","Wash & Iron","5 BD");
        clothOrderedLsits.add(firstOrder);
        clothOrderedLsits.add(secondOrder);
        clothOrderedLsits.add(thirdOrder);
        clothOrderedLsits.add(fourthOrder);
        clothsWashListAdapter.notifyDataSetChanged();

    }

    public void ivBackbtn(View v){
        finish();
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
