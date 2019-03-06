package com.bedrock.bosszp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bedrock.bosszp.fragment.message.reaction.CheckedMeFragment;
import com.bedrock.bosszp.fragment.message.reaction.InterestedFragment;
import com.bedrock.bosszp.fragment.message.reaction.NewJobFragment;

import java.util.List;

public class MsgPagerAdapter extends FragmentPagerAdapter {

    private List<String> titles ;

    public MsgPagerAdapter(FragmentManager fm,List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            default:
                return InterestedFragment.getInstance();
            case 1:
                return CheckedMeFragment.getInstance();
            case 2:
                return NewJobFragment.getInstance();
        }
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
