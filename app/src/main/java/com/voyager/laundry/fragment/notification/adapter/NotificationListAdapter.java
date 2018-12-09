package com.voyager.laundry.fragment.notification.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.laundry.R;

import com.voyager.laundry.fragment.notification.model.NotificationList;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ViewHolder> {

    private List<NotificationList> notificationLists;

    public NotificationListAdapter(List<NotificationList> notificationLists) {
        this.notificationLists = notificationLists;
    }

    @Override
    public NotificationListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_order_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivNotification.setImageResource(notificationLists.get(position).getNotificationImg());
        holder.tvNotificationHeading.setText(notificationLists.get(position).getNotificationHeading());
        holder.tvNotificationTime.setText(notificationLists.get(position).getNotificationTime());
        holder.tvNotificationSubHeading.setText(notificationLists.get(position).getNotificationSubHeading());

    }

    @Override
    public int getItemCount() {
        return notificationLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivNotification;
        private TextView tvNotificationHeading;
        private TextView tvNotificationTime;
        private TextView tvNotificationSubHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            ivNotification =  itemView.findViewById(R.id.ivNotification);
            tvNotificationHeading = itemView.findViewById(R.id.tvNotificationHeading);
            tvNotificationTime = itemView.findViewById(R.id.tvNotificationTime);
            tvNotificationSubHeading = itemView.findViewById(R.id.tvNotificationSubHeading);
        }
    }
}