package com.voyager.laundry.activity.ratepage;

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
import com.voyager.laundry.activity.review.adapter.ClothsWashListAdapter;
import com.voyager.laundry.activity.review.model.ClothOrderedLsit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rimon on 16-12-2018.
 */

public class RatePage  extends AppCompatActivity {

    LinearLayout llContBtn;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_order);
        activity = this;

    }



    public void ivBackbtn(View v){
        finish();
    }


    public void btnSubmit(View v){
        finish();
    }
}
