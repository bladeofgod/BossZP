package com.bedrock.bosszp.adapter;

import android.app.Activity;
import android.view.ViewGroup;

import com.bedrock.bosszp.model.CompanyBean;
import com.bedrock.bosszp.view_holder.CompanyViewHolder;

import zuo.biao.library.base.BaseAdapter;

public class CompanyAdapter extends BaseAdapter<CompanyBean, CompanyViewHolder> {
    public CompanyAdapter(Activity context) {
        super(context);
    }

    @Override
    public CompanyViewHolder createView(int viewType, ViewGroup parent) {
        return new CompanyViewHolder(context,parent);
    }
}
