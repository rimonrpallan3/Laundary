package com.voyager.laundry.fragment.couponpage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.couponpage.model.Coupon;
import com.voyager.laundry.fragment.notification.model.NotificationList;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class CouponListAdapter extends RecyclerView.Adapter<CouponListAdapter.ViewHolder> {

    private List<Coupon> couponList;

    public CouponListAdapter(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    @Override
    public CouponListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_cuopon_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/

        holder.tvCouponHeading.setText(couponList.get(position).getCouponHeading());
        holder.tvCouponSubHeading.setText(couponList.get(position).getCouponSubHeading());
        holder.btnCoupon.setText(couponList.get(position).getCouponBtnTxt());

    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCouponHeading;
        private TextView tvCouponSubHeading;
        private Button btnCoupon;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCouponHeading = itemView.findViewById(R.id.tvCouponHeading);
            tvCouponSubHeading = itemView.findViewById(R.id.tvCouponSubHeading);
            btnCoupon = itemView.findViewById(R.id.btnCoupon);
        }
    }
}