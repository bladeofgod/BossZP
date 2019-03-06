package com.bedrock.bosszp.fragment.message.reaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.CompanyAdapter;
import com.bedrock.bosszp.model.CompanyBean;
import com.bedrock.bosszp.view_holder.CompanyViewHolder;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class CheckedMeFragment extends BaseHttpRecyclerFragment<CompanyBean, CompanyViewHolder, CompanyAdapter> {

    public static CheckedMeFragment getInstance(){
        return new CheckedMeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_msg_reac_checked);

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
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    @Override
    public void setList(final List<CompanyBean> list) {
        setList(new AdapterCallBack<CompanyAdapter>() {
            @Override
            public CompanyAdapter createAdapter() {
                return new CompanyAdapter(context);
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

        final List<CompanyBean> list = new ArrayList<>();
        for (int i=0;i<15;i++){
            list.add(new CompanyBean(
                    "字节跳动 "+i,"",
                    "北京" + i,"",
                    "正在热招 职位："+(i*200)+"位"
            ));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,page>=3 ? null:JSON.toJSONString(list),null);
            }
        },1000);

    }

    @Override
    public List<CompanyBean> parseArray(String json) {
        return JSON.parseArray(json,CompanyBean.class);
    }
}
