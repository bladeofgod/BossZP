package com.bedrock.bosszp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.fragment.place.BusinessFragment;
import com.bedrock.bosszp.fragment.place.NearFragment;
import com.bedrock.bosszp.fragment.place.SubwayFragment;

import zuo.biao.library.base.BaseTabFragment;

public class PlaceSelectorFragment extends BaseTabFragment implements View.OnClickListener {

    public static PlaceSelectorFragment getInstance(){
        return new PlaceSelectorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState, R.layout.selector_place_fragment);

        initView();
        initData();
        initEvent();

        return view;
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    protected String[] getTabNames() {
        return new String[]{"附近","商圈","地铁"};
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position){
            default:
                return NearFragment.getInstance();
            case 1:
                return BusinessFragment.getInstance();
            case 2:
                //return SubwayFragment.getInstance();
                return BusinessFragment.getInstance();

        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
