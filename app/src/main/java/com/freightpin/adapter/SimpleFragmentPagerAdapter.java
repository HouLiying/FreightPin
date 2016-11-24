package com.freightpin.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.freightpin.R;
import com.freightpin.fragment.PageFragment;

/**
 * Created by 侯丽英 on 2016/11/24.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Activity mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public SimpleFragmentPagerAdapter(FragmentManager fm, Activity context) {
        super(fm);
        mContext =context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return 4;
    }

    public View getTabView(int count){
        View tabView;
        tabView = LayoutInflater.from(mContext).inflate(R.layout.mainactivity_tab,null);
        TextView mTxtTab = (TextView) tabView.findViewById(R.id.txt_tab);
        switch (count){
            case 0:
                mTxtTab.setText(mContext.getResources().getString(R.string.tab_name1));
                break;
            case 1:
                mTxtTab.setText(mContext.getResources().getString(R.string.tab_name2));
                break;
            case 2:
                mTxtTab.setText(mContext.getResources().getString(R.string.tab_name3));
                break;
            case 3:
                mTxtTab.setText(mContext.getResources().getString(R.string.tab_name4));
                break;
        }
        return tabView;
    }
}
