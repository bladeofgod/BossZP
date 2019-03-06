package com.bedrock.bosszp.adapter;

import android.app.Activity;
import android.view.ViewGroup;

import com.bedrock.bosszp.model.ContacterBean;
import com.bedrock.bosszp.view_holder.ContacterViewHolder;

import zuo.biao.library.base.BaseAdapter;

public class ContacterAdapter extends BaseAdapter<ContacterBean, ContacterViewHolder> {

    public ContacterAdapter(Activity context) {
        super(context);
    }

    @Override
    public ContacterViewHolder createView(int viewType, ViewGroup parent) {
        return new ContacterViewHolder(context,parent);
    }
}
