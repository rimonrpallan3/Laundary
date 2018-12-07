package com.voyager.laundry.fragment.homepage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.model.OrderList;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    private List<OrderList> orderLists;

    public OrderListAdapter(List<OrderList> orderLists) {
        this.orderLists = orderLists;
    }

    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_order_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivOrder.setImageResource(orderLists.get(position).getOrderImg());
        holder.tvOrderNo.setText(orderLists.get(position).getItemOrderNo().toString());
        holder.tvOrderStatus.setText(orderLists.get(position).getItemordeStatus());
        holder.tvOrderAmt.setText(orderLists.get(position).getItemOrderAmt());
        holder.tvOrderDate.setText(orderLists.get(position).getItemOrderDate());
    }

    @Override
    public int getItemCount() {
        return orderLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivOrder;
        private TextView tvOrderNo;
        private TextView tvOrderStatus;
        private TextView tvOrderAmt;
        private TextView tvOrderDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ivOrder =  itemView.findViewById(R.id.ivOrder);
            tvOrderNo = itemView.findViewById(R.id.tvOrderNo);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvOrderAmt = itemView.findViewById(R.id.tvOrderAmt);
            tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
        }
    }
}