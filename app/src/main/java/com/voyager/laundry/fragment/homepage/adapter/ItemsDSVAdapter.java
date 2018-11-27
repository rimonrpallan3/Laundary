package com.voyager.laundry.fragment.homepage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.voyager.laundry.R;

import com.squareup.picasso.Picasso;
import com.voyager.laundry.fragment.homepage.model.Item;

import java.util.List;

/**
 * Created by User on 19-Nov-18.
 */

public class ItemsDSVAdapter extends RecyclerView.Adapter<ItemsDSVAdapter.ViewHolder> {

    private List<Item> data;

    public ItemsDSVAdapter(List<Item> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.content_hz_img, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext())
                .load(data.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}