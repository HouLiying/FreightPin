package com.freightpin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freightpin.R;

/**
 * Created by 侯丽英 on 2016/11/24.
 */

public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static PageFragment newInstance(int page){
        Bundle args =new Bundle();
        args.putInt(ARG_PAGE,page);
        PageFragment fragment =new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainactivity_fragment_freight,null);
        TextView mTxtFragmentFreight = (TextView) view.findViewById(R.id.txt_fragment_freight);
        mTxtFragmentFreight.setText("Fragment"+mPage);
        return view;
    }
}
