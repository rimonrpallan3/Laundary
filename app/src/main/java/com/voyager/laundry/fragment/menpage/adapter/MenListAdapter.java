package com.voyager.laundry.fragment.menpage.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.couponpage.model.Coupon;
import com.voyager.laundry.fragment.menpage.model.Men;

import java.util.List;

/**
 * Created by User on 27-Nov-18.
 */

public class MenListAdapter extends RecyclerView.Adapter<MenListAdapter.ViewHolder> {

    private List<Men> menList;
    int minteger = 0;
    Activity activity;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;

    public MenListAdapter(List<Men> menList, Activity activity) {
        this.menList = menList;
        this.activity = activity;
    }

    @Override
    public MenListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_men_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*Picasso.with(holder.itemView.getContext())
                .load(orderLists.get(position).getItemOrderImg())
                .into(holder.ivOrder);*/
        holder.ivMen.setImageResource(menList.get(position).getDress());
        holder.tvMenHeading.setText(menList.get(position).getMenheading());

        holder.ivMenAmt.setText(menList.get(position).getIntialAmt());
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

        holder.llWashList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
              /*  LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup,null);

                Button btnPopCancel = (Button) customView.findViewById(R.id.btnPopCancel);
                Button btnPopDone = (Button) customView.findViewById(R.id.btnPopDone);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //display the popup window
               popupWindow.showAtLocation(v.getRootView(), Gravity.CENTER, 0, 0);

                //close the popup window on button click
                btnPopCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                //close the popup window on button click
                btnPopDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAsDropDown(customView, 0, 0);*/

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                builder.setTitle("T Shirt Wash Only 2BD");
                View dialogLayout = inflater.inflate(R.layout.popup, null);
                //final RatingBar ratingBar = dialogLayout.findViewById(R.id.ratingBar);
                final Button btnPopCancel = (Button) dialogLayout.findViewById(R.id.btnPopCancel);
                final Button btnPopDone = (Button) dialogLayout.findViewById(R.id.btnPopDone);
                final CheckBox cbFirstCheck =  dialogLayout.findViewById(R.id.cbFirstCheck);
                final CheckBox cbSecondCheck =  dialogLayout.findViewById(R.id.cbSecondCheck);
                final CheckBox cbThirdCheck =  dialogLayout.findViewById(R.id.cbThirdCheck);
                builder.setView(dialogLayout);
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(activity.getApplicationContext(), "Rating is " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(activity.getApplicationContext(), "Rating is " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();

            }
        });


    }


    @Override
    public int getItemCount() {
        return menList.size();
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