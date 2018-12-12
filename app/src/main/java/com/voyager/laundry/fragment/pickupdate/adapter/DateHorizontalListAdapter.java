package com.voyager.laundry.fragment.pickupdate.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.SelectClothes.SelectedClothes;
import com.voyager.laundry.fragment.homepage.model.ServiceItems;
import com.voyager.laundry.fragment.pickupdate.model.Date;

import java.util.List;

/**
 * Created by User on 22-Nov-18.
 */

public class DateHorizontalListAdapter extends RecyclerView.Adapter<DateHorizontalListAdapter.ServiceViewHolder>{
    private List<Date> dateList;
    Activity activity;

    public DateHorizontalListAdapter(List<Date> dateList, Activity activity){
        this.dateList = dateList;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_horizontal_pickup_date, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        //Picasso.with(context).load(serviceItems.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        holder.btnDate.setText(dateList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        Button btnDate;
        public ServiceViewHolder(View view) {
            super(view);
            btnDate=view.findViewById(R.id.btnDate);
        }
    }
}