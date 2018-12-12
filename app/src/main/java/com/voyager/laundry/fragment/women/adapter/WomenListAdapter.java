package com.voyager.laundry.fragment.women.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.menpage.model.Men;
import com.voyager.laundry.fragment.women.model.Women;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class WomenListAdapter extends RecyclerView.Adapter<WomenListAdapter.ViewHolder> {

    private List<Women> womenList;
    int minteger = 0;

    public WomenListAdapter(List<Women> womenList) {
        this.womenList = womenList;
    }

    @Override
    public WomenListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_women_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivMen.setImageResource(womenList.get(position).getDress());
        holder.tvMenHeading.setText(womenList.get(position).getMenheading());

        holder.ivMenAmt.setText(womenList.get(position).getIntialAmt());
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
        return womenList.size();
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