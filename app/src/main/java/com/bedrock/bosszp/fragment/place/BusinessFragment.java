package com.bedrock.bosszp.fragment.place;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.popup_place_business.BusinessFragmentAdapter;
import com.bedrock.bosszp.adapter.popup_place_business.VerticalTabAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;
import zuo.biao.library.base.BaseFragment;

public class BusinessFragment extends BaseFragment {

    public static BusinessFragment getInstance(){
        return new BusinessFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_place_business);

        initView();
        initData();
        initEvent();

        return view;
    }

    private List<String> titles;
    private VerticalTabLayout tabLayout;
    private YViewPager viewPager;
    private BusinessFragmentAdapter adapter;

    @Override
    public void initView() {
        titles = new ArrayList<>();
        for (int i=0;i<20;i++){
            titles.add("Title -"+i+"-");
        }

        tabLayout = findView(R.id.business_tab_layout);
        tabLayout.setTabAdapter(new VerticalTabAdapter(titles,context));
        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });


        viewPager = findView(R.id.business_view_pager);
        adapter = new BusinessFragmentAdapter(getFragmentManager(),context,titles.toArray(new String[20]));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
