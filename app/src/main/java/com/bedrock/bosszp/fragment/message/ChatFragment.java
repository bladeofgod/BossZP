package com.bedrock.bosszp.fragment.message;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.ContacterAdapter;
import com.bedrock.bosszp.model.ContacterBean;
import com.bedrock.bosszp.view_holder.ContacterViewHolder;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.base.BaseListFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;
import zuo.biao.library.util.TimeUtil;

public class ChatFragment extends BaseHttpRecyclerFragment<ContacterBean, ContacterViewHolder, ContacterAdapter> {

    public static ChatFragment getInstance(){
        return new ChatFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_message_chat);

        initView();
        initData();
        initEvent();

        onRefresh();
        return view;

    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void setList(final List<ContacterBean> list) {
        setList(new AdapterCallBack<ContacterAdapter>() {
            @Override
            public ContacterAdapter createAdapter() {
                return new ContacterAdapter(context);
            }

            @Override
            public void refreshAdapter() {
                adapter.refresh(list);

            }
        });

    }

    @Override
    public void getListAsync(final int page) {

        showProgressDialog(R.string.loading);

        final List<ContacterBean> list = new ArrayList<>();
        for (int i=0;i<15;i++){
            list.add(new ContacterBean(
                    "张亮 "+i,
                    "最近给你发送了 " + (i+2)+"条信息",
                    TimeUtil.getWholeTime(System.currentTimeMillis())
            ));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,
                        page>=3 ?null: JSON.toJSONString(list),null);
            }
        },1000);

    }

    @Override
    public List<ContacterBean> parseArray(String json) {
        return JSON.parseArray(json,ContacterBean.class);
    }
}
