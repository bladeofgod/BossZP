package com.bedrock.bosszp.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.JobsAdapter;
import com.bedrock.bosszp.banner.GlideImageLoader;
import com.bedrock.bosszp.model.JobBean;
import com.bedrock.bosszp.view.part_shadow_popup.CompanyPopupView;
import com.bedrock.bosszp.view.part_shadow_popup.DemandPopupView;
import com.bedrock.bosszp.view.part_shadow_popup.PlacePopupView;
import com.bedrock.bosszp.view.part_shadow_popup.RecommendPopupView;
import com.bedrock.bosszp.view_holder.JobsViewHolder;
import com.lxj.xpopup.XPopup;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.util.JSON;

public class JobsFragment extends BaseHttpRecyclerFragment<JobBean, JobsViewHolder, JobsAdapter>
    implements View.OnClickListener {

    public static JobsFragment getInstance(){
        return new JobsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_jobs);

        initView();
        initData();
        initEvent();

        onRefresh();
        return view;

    }

    List<Integer> images;

    @Override
    public void initView() {
        super.initView();
        loadBanner();

    }
    private void loadBanner(){
        images = new ArrayList<>();
        images.add(R.drawable.b1);
        images.add(R.drawable.b2);
        images.add(R.drawable.b3);

        Banner banner =  findView(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
    }

    @Override
    public void setList(final List list) {

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
    public void initData() {
        super.initData();

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
                onHttpResponse(-page,
                        page>=5 ? null : JSON.toJSONString(list),null);
            }
        },1000);

    }

    @Override
    public List<JobBean> parseArray(String json) {
        return JSON.parseArray(json,JobBean.class);
    }

    @Override
    public void initEvent() {
        super.initEvent();

        findView(R.id.tv_recommend).setOnClickListener(this);
        findView(R.id.tv_place).setOnClickListener(this);
        findView(R.id.tv_company).setOnClickListener(this);
        findView(R.id.tv_demand).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_recommend:
                XPopup.get(context)
                        .asCustom(new RecommendPopupView(context))
                        .atView(findView(R.id.tv_recommend))
                        .show();
                break;
            case R.id.tv_place:
                XPopup.get(context)
                        .asCustom(new PlacePopupView(context,getFragmentManager()))
                        .atView(findView(R.id.tv_place))
                        .show();
                break;
            case R.id.tv_company:
                XPopup.get(context)
                        .asCustom(new CompanyPopupView(context))
                        .atView(findView(R.id.tv_company))
                        .show();
                break;
            case R.id.tv_demand:
                XPopup.get(context)
                        .asCustom(new DemandPopupView(context))
                        .atView(findView(R.id.tv_demand))
                        .show();
                break;
        }

    }
}
