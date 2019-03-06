package com.bedrock.bosszp.fragment.message.reaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.JobsAdapter;
import com.bedrock.bosszp.model.JobBean;
import com.bedrock.bosszp.view_holder.JobsViewHolder;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class NewJobFragment extends BaseHttpRecyclerFragment<JobBean, JobsViewHolder, JobsAdapter> {

    public static NewJobFragment getInstance(){
        return new NewJobFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_msg_reac_new);

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
    public void setList(final List<JobBean> list) {
        setList(new AdapterCallBack<JobsAdapter>() {
            @Override
            public JobsAdapter createAdapter() {
                return new JobsAdapter(context);
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

        final List<JobBean> list = new ArrayList<>();

        for (int i=0;i<10;i++){
            JobBean bean = new JobBean(
                    "android 工程师",
                    "巨石科技公司",
                    "10-12K",
                    "张经理"
            );

            list.add(bean);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,page>=5? null:JSON.toJSONString(list),null);
            }
        },1000);

    }

    @Override
    public List<JobBean> parseArray(String json) {
        return JSON.parseArray(json,JobBean.class);
    }
}
