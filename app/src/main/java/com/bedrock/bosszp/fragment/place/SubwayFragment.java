package com.bedrock.bosszp.fragment.place;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;

import zuo.biao.library.base.BaseFragment;

public class SubwayFragment extends BaseFragment {

    public static SubwayFragment getInstance(){
        return new SubwayFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_place_subway);
        initView();
        initData();
        initEvent();
        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
