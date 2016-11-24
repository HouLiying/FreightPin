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

import java.util.ArrayList;

/**
 * Created by 侯丽英 on 2016/11/24.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Activity mContext;
    private ArrayList<String> tabName;//首页底部tab标签
    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public SimpleFragmentPagerAdapter(FragmentManager fm, Activity context, ArrayList<String> tabName) {
        super(fm);
        mContext =context;
        this.tabName =tabName;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return tabName.size();
    }

    public View getTabView(int count){
        View tabView;
        tabView = LayoutInflater.from(mContext).inflate(R.layout.mainactivity_tab,null);
        TextView mTxtTab = (TextView) tabView.findViewById(R.id.txt_tab);
        mTxtTab.setText(tabName.get(count));
        return tabView;
    }
}
