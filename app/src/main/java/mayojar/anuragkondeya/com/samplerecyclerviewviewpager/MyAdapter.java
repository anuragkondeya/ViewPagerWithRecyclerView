package mayojar.anuragkondeya.com.samplerecyclerviewviewpager;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anuragkondeya on 9/6/17.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<String> mData;
    AppCompatActivity mActivity;

    MyAdapter(AppCompatActivity activity,List<String> data ){
        mData = data;
        mActivity = activity;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

            LinearLayout baseLayout;

            public ViewHolder(LinearLayout v) {
                super(v);
                baseLayout = v;

            }
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.baseframe, parent, false);
        ViewHolder viewHolder = new ViewHolder(linearLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ViewPagerAdapter pageAdapter =  new ViewPagerAdapter(mActivity,mData.get(position));
        ViewPager vewPager = (ViewPager) holder.baseLayout.findViewById(R.id.viewpager);
        vewPager.setAdapter(pageAdapter);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
