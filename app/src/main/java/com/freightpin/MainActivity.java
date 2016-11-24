package com.freightpin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.freightpin.adapter.SimpleFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    private ArrayList<String> tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    private void initDate(){
        tabName =new ArrayList<>();
        tabName.add(getResources().getString(R.string.tab_name1));
        tabName.add(getResources().getString(R.string.tab_name2));
        tabName.add(getResources().getString(R.string.tab_name3));
        tabName.add(getResources().getString(R.string.tab_name4));
    }

    private void initView(){
        SimpleFragmentPagerAdapter viewPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this,tabName);
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        for(int i=0;i<mTabLayout.getTabCount();i++){
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(viewPagerAdapter.getTabView(i));
        }
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
