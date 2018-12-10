package com.voyager.laundry.fragment.homepage.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;
import com.voyager.laundry.R;
import com.voyager.laundry.fragment.homepage.model.HeaderItem;
import com.voyager.laundry.fragment.homepage.model.ServiceItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by User on 10-Dec-18.
 */

public class RecycleViewSlidingAdapter extends RecyclerView.Adapter<RecycleViewSlidingAdapter.SlidingViewHolder>{
    private List<HeaderItem> headerItems;
    Context context;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    private static final Integer[] IMAGES= {R.drawable.five,R.drawable.five,R.drawable.three,R.drawable.five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    public RecycleViewSlidingAdapter(List<HeaderItem> headerItems, Context context){
        this.headerItems = headerItems;
        this.context = context;
    }

    @Override
    public SlidingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_header, parent, false);
        SlidingViewHolder gvh = new SlidingViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(final SlidingViewHolder holder, final int position) {
       // holder.image.setImageResource(headerItems.get(position).getBannerImg());
        //Picasso.with(context).load(serviceItems.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);



        holder.mPager.setAdapter(new SlidingImage_Adapter(context,ImagesArray));

        holder.indicator.setViewPager(holder.mPager);

        final float density = context.getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        holder.indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                holder.mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        holder.indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return headerItems.size();
    }

    public class SlidingViewHolder extends RecyclerView.ViewHolder {
        CirclePageIndicator indicator;
        ViewPager mPager;
        public SlidingViewHolder(View view) {
            super(view);
            mPager = (ViewPager) view.findViewById(R.id.pager);
            indicator = (CirclePageIndicator)
                    view.findViewById(R.id.indicator);

        }
    }
}