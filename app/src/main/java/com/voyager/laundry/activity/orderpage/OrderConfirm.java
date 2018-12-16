package com.voyager.laundry.activity.orderpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.address.PickAddress;
import com.voyager.laundry.activity.orderpage.adapter.OrderWashListAdapter;
import com.voyager.laundry.activity.ratepage.RatePage;
import com.voyager.laundry.activity.review.adapter.ClothsWashListAdapter;
import com.voyager.laundry.activity.review.model.ClothOrderedLsit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rimon on 14-12-2018.
 */

public class OrderConfirm extends AppCompatActivity {

    LinearLayout llRateBtn;
    RecyclerView rvReviewOrder;
    OrderWashListAdapter washListAdapter;
    List<ClothOrderedLsit> clothOrderedLsits= new ArrayList<>();
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        rvReviewOrder = findViewById(R.id.rvReviewOrder);
        llRateBtn = findViewById(R.id.llRateBtn);

        washListAdapter = new OrderWashListAdapter(clothOrderedLsits);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rvReviewOrder.setLayoutManager(horizontalLayoutManager);
        rvReviewOrder.setAdapter(washListAdapter);
        rvReviewOrder.setLayoutFrozen(true);
        populateOrderList();

        llRateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RatePage.class);
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
        washListAdapter.notifyDataSetChanged();

    }

    public void ivBackbtn(View v){
        finish();
    }
}
