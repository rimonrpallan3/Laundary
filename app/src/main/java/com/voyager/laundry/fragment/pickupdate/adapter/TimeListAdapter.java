package com.voyager.laundry.fragment.pickupdate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.model.OrderList;
import com.voyager.laundry.fragment.pickupdate.model.Time;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.ViewHolder> {

    private List<Time> timeList;

    public TimeListAdapter(List<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public TimeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_pickup_time, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.btnTime1.setText(timeList.get(position).getTime1());
        holder.btnTime2.setText(timeList.get(position).getTime2());
}

    @Override
    public int getItemCount() {
        return timeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        Button btnTime1;
        Button btnTime2;

        public ViewHolder(View itemView) {
            super(itemView);
            btnTime1=itemView.findViewById(R.id.btnTime1);
            btnTime2=itemView.findViewById(R.id.btnTime2);
        }
    }
}