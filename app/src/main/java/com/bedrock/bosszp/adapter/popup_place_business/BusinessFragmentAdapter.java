package com.bedrock.bosszp.adapter.popup_place_business;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bedrock.bosszp.fragment.place.business_fragment.BusinessSubFragment;

import java.util.List;

public class BusinessFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles;

    public BusinessFragmentAdapter(FragmentManager fm, Context context,String[] titles) {
        super(fm);
        this.context = context;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return BusinessSubFragment.getInstance(titles[i]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
