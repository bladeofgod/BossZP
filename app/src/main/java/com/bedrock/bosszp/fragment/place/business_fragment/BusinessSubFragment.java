package com.bedrock.bosszp.fragment.place.business_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.BusinessAdapter;
import com.bedrock.bosszp.fragment.place.NearFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseListFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.model.Entry;

public class BusinessSubFragment extends BaseListFragment<Entry<String,String>, ListView, BusinessAdapter> {

    public static BusinessSubFragment getInstance(String keyWord){
        BusinessSubFragment fragment = new BusinessSubFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",keyWord);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String keyWord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_place_busi_sub);

        argument = getArguments();
        keyWord = argument.getString("key");

        initView();
        initData();
        initEvent();

        onRefresh();

        return view;
    }

    @Override
    public void initView() {
        super.initView();

    }

    @Override
    public void setList(final List list) {

        setList(new AdapterCallBack<BusinessAdapter>() {
            @Override
            public BusinessAdapter createAdapter() {
                return new BusinessAdapter(context);
            }

            @Override
            public void refreshAdapter() {

                adapter.refresh(list);

            }
        });

    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void getListAsync(int page) {
        List<Entry<String,String>> list = new ArrayList<>();

        for (int i=0 ; i <15;i++){
            list.add(new Entry<String, String>("key" + i,keyWord + "__"+i));
        }

        onLoadSucceed(page,list);


    }

    @Override
    public void initEvent() {
        super.initEvent();

    }
}
