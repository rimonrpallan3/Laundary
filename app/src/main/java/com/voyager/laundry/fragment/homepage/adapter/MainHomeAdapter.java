package com.voyager.laundry.fragment.homepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.model.HeaderItem;
import com.voyager.laundry.fragment.homepage.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10-Dec-18.
 */

public class MainHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Item> itemList =new ArrayList<>();
    private Context context;
    private ClickListener clickListener;
    private LayoutInflater infalter;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;




    public MainHomeAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.infalter = LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println(" ------------ MainHomeAdapter onCreateViewHolder viewType : "+viewType);

        if(viewType == 1){
            View rootView = infalter.inflate(R.layout.horizontal_list_service_item,parent,false);
            return new mBodyViewHolder(rootView);
        }else if(viewType == 2){
            View rootView = infalter.inflate(R.layout.content_order_list,parent,false);
            return new mFooterViewHolder(rootView);
        } else{
            View rootView = infalter.inflate(R.layout.content_slidingimages,parent,false);
            return new mHeaderViewHolder(rootView);
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holderViews, final int position) {
        if(holderViews instanceof mBodyViewHolder) {
            mBodyViewHolder holder = (mBodyViewHolder) holderViews;

           // holder.tvDrawerItem.setText(itemList.get(position).getName());


        }  else if (holderViews instanceof mFooterViewHolder){
            System.out.println(" ------------ DrawerListAdapter onBindViewHolder drawer_header position : "+position);
            final mFooterViewHolder holder = (mFooterViewHolder) holderViews;
            final HeaderItem dataItem = (HeaderItem) itemList.get(position);


        }else if (holderViews instanceof mHeaderViewHolder){
            System.out.println(" ------------ DrawerListAdapter onBindViewHolder drawer_header position : "+position);
            final mHeaderViewHolder holder = (mHeaderViewHolder) holderViews;
            final HeaderItem dataItem = (HeaderItem) itemList.get(position);


        }

    }


    @Override
    public int getItemCount() {
        if (itemList != null && itemList.size() > 0) {
            return itemList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        System.out.println(" ------------ DrawerListAdapter getItemViewType position : "+position);
        if(position == 0 && itemList.get(position) instanceof HeaderItem){
            System.out.println(" ------------ DrawerListAdapter onBindViewHolder getItemViewType position : "+position);
            return TYPE_HEADER;
        }
        return TYPE_FOOTER;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public  class mHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView app_name;
        public View root;

        public mHeaderViewHolder(View itemView) {
            super(itemView);
            root = itemView;

            /*name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);*/
        }

        @Override
        public void onClick(View v) {

        }
    }


    public  class mFooterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        //for item menu
        private ImageView ivOrder;
        private TextView tvOrderNo;
        private TextView tvOrderStatus;
        private TextView tvOrderAmt;
        private TextView tvOrderDate;

        public mFooterViewHolder(View itemView) {
            super(itemView);
            ivOrder =  itemView.findViewById(R.id.ivOrder);
            tvOrderNo = itemView.findViewById(R.id.tvOrderNo);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            tvOrderAmt = itemView.findViewById(R.id.tvOrderAmt);
            tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
        }


        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }

            //delete(getPosition());


        }
    }

    public  class mBodyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivHzList;
        TextView tvHzHead;
        TextView tvHzSubHead;
        public mBodyViewHolder(View view) {
            super(view);
            ivHzList=view.findViewById(R.id.ivHzList);
            tvHzHead=view.findViewById(R.id.tvHzHead);
            tvHzSubHead=view.findViewById(R.id.tvHzSubHead);
        }

        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }

            //delete(getPosition());


        }
    }
    public void setClickListener(ClickListener clicklistener){

        this.clickListener = clicklistener;

    }


    public interface ClickListener{
        public void itemClicked(View view, int position);
    }

    public List<Item> getData(){

        return this.itemList;
    }

}