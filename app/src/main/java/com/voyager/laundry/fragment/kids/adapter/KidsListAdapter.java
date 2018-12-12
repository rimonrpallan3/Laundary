package com.voyager.laundry.fragment.kids.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.kids.model.Kids;
import com.voyager.laundry.fragment.others.model.Other;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class KidsListAdapter extends RecyclerView.Adapter<KidsListAdapter.ViewHolder> {

    private List<Kids> kidsList;
    int minteger = 0;

    public KidsListAdapter(List<Kids> kidsList) {
        this.kidsList = kidsList;
    }

    @Override
    public KidsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_kids_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivMen.setImageResource(kidsList.get(position).getDress());
        holder.tvMenHeading.setText(kidsList.get(position).getMenheading());

        holder.ivMenAmt.setText(kidsList.get(position).getIntialAmt());
        holder.llWashList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger - 1;
                holder.tvMenIDNo.setText(""+minteger);
            }
        });
        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minteger = minteger + 1;
                holder.tvMenIDNo.setText(""+minteger);
            }
        });

    }


    @Override
    public int getItemCount() {
        return kidsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMenHeading;
        private TextView ivMenAmt;
        private ImageView ivMen;
        private LinearLayout llWashList;
        private TextView tvMenIDNo;
        private Button decrease;
        private Button increase;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMenHeading = itemView.findViewById(R.id.tvMenHeading);
            ivMenAmt = itemView.findViewById(R.id.ivMenAmt);
            llWashList = itemView.findViewById(R.id.llWashList);
            ivMen = itemView.findViewById(R.id.ivMen);
            tvMenIDNo = itemView.findViewById(R.id.tvMenIDNo);
            increase = itemView.findViewById(R.id.btnMenIncrease);
            decrease = itemView.findViewById(R.id.btnMenDecrease);
        }
    }
}