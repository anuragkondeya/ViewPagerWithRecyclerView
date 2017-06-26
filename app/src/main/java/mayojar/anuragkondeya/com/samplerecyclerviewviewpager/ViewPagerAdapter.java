package mayojar.anuragkondeya.com.samplerecyclerviewviewpager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by anuragkondeya on 9/6/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private String mTitle;
    private Activity mActivity;


    public ViewPagerAdapter(Activity activity,String title) {
        mActivity = activity;
        mTitle = title;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflator  = (LayoutInflater) mActivity.getSystemService(mActivity.LAYOUT_INFLATER_SERVICE);
        View view;

        if(0==position){
            view =  inflator.inflate(R.layout.fragment_title,container,false);
            TextView titleTv = (TextView) view.findViewById(R.id.titlefrag);
            titleTv.setText(mTitle);
            Log.e("Anurag","View 1");

        }else{
            view = inflator.inflate(R.layout.fragment_delete,container,false);
            Log.e("Anurag","View 2");
        }
        Log.e("Anurag","View "+view);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Removes the page from the container for the given position. We simply removed object using removeView()
        // but could’ve also used removeViewAt() by passing it the position.
        try {
            // Remove the view from the container
            container.removeView((View) object);
        } catch (Exception e) {

        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
