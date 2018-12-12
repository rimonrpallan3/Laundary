package com.voyager.laundry.activity.review.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.activity.review.model.ClothOrderedLsit;
import com.voyager.laundry.fragment.kids.model.Kids;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class ClothsWashListAdapter extends RecyclerView.Adapter<ClothsWashListAdapter.ViewHolder> {

    private List<ClothOrderedLsit> clothOrderedLsits;
    int minteger = 0;

    public ClothsWashListAdapter(List<ClothOrderedLsit> clothOrderedLsits) {
        this.clothOrderedLsits = clothOrderedLsits;
    }

    @Override
    public ClothsWashListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_cloth_ordered_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.tvClothOrdered.setText(clothOrderedLsits.get(position).getClothCount());
        holder.tvClothType.setText(clothOrderedLsits.get(position).getType());

        holder.tvClothAmt.setText(clothOrderedLsits.get(position).getAmt());

    }


    @Override
    public int getItemCount() {
        return clothOrderedLsits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvClothOrdered;
        private TextView tvClothType;
        private TextView tvClothAmt;

        public ViewHolder(View itemView) {
            super(itemView);
            tvClothOrdered = itemView.findViewById(R.id.tvClothOrdered);
            tvClothType = itemView.findViewById(R.id.tvClothType);
            tvClothAmt = itemView.findViewById(R.id.tvClothAmt);
        }
    }
}