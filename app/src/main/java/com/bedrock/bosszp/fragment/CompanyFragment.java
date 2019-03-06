package com.bedrock.bosszp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.CompanyAdapter;
import com.bedrock.bosszp.model.CompanyBean;
import com.bedrock.bosszp.view.part_shadow_popup.CompanyFragPopupView;
import com.bedrock.bosszp.view_holder.CompanyViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.impl.ConfirmPopupView;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class CompanyFragment extends BaseHttpRecyclerFragment<CompanyBean, CompanyViewHolder, CompanyAdapter>
implements View.OnClickListener {

    public static CompanyFragment getInstance(){
        return new CompanyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        setContentView(R.layout.fragment_company);

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
    public void initData() {
        super.initData();

    }

    @Override
    public void getListAsync(final int page) {
        showProgressDialog(R.string.loading);
        final List<CompanyBean> beanList = new ArrayList<>();
        for (int i=0;i<10;i++){
            beanList.add(new CompanyBean(
                    "字节跳动 "+i,"",
                    "北京" + i,"",
                    "正在热招 职位："+(i*200)+"位"
            ));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onHttpResponse(-page,
                        page >= 3? null :JSON.toJSONString(beanList),null);

            }
        },1000);

    }

    @Override
    public List<CompanyBean> parseArray(String json) {
        return JSON.parseArray(json,CompanyBean.class);
    }

    @Override
    public void initEvent() {
        super.initEvent();

        findView(R.id.tv_financing).setOnClickListener(this);
        findView(R.id.tv_size).setOnClickListener(this);
        findView(R.id.tv_profession).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_financing:
                XPopup.get(context)
                        .asCustom(new CompanyFragPopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
            case R.id.tv_size:
                XPopup.get(context)
                        .asCustom(new CompanyFragPopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
            case R.id.tv_profession:
                XPopup.get(context)
                        .asCustom(new CompanyFragPopupView(context))
                        .atView(findView(R.id.tv_financing))
                        .show();
                break;
        }

    }
}
