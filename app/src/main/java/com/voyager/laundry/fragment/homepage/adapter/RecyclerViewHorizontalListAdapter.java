package com.voyager.laundry.fragment.homepage.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.SelectClothes.SelectedClothes;
import com.voyager.laundry.activity.otppage.OTPPage;
import com.voyager.laundry.fragment.homepage.model.ServiceItems;

import java.util.List;

import static com.voyager.laundry.common.Helper.REQUEST_REGISTERED;

/**
 * Created by User on 22-Nov-18.
 */

public class RecyclerViewHorizontalListAdapter extends RecyclerView.Adapter<RecyclerViewHorizontalListAdapter.ServiceViewHolder>{
    private List<ServiceItems> serviceItems;
    Activity activity;

    public RecyclerViewHorizontalListAdapter(List<ServiceItems> serviceItems, Activity activity){
        this.serviceItems = serviceItems;
        this.activity = activity;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list_service_item, parent, false);
        ServiceViewHolder gvh = new ServiceViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, final int position) {
        holder.ivHzList.setImageResource(serviceItems.get(position).getServiceImage());
        //Picasso.with(context).load(serviceItems.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        holder.tvHzHead.setText(serviceItems.get(position).getHeading());
        holder.tvHzSubHead.setText(serviceItems.get(position).getSubHeading());
        holder.ivHzList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = serviceItems.get(position).getHeading().toString();
                Toast.makeText(activity, productName + " is selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SelectedClothes.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceItems.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHzList;
        TextView tvHzHead;
        TextView tvHzSubHead;
        public ServiceViewHolder(View view) {
            super(view);
            ivHzList=view.findViewById(R.id.ivHzList);
            tvHzHead=view.findViewById(R.id.tvHzHead);
            tvHzSubHead=view.findViewById(R.id.tvHzSubHead);
        }
    }
}