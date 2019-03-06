package com.bedrock.bosszp.adapter;

import android.app.Activity;
import android.view.ViewGroup;

import com.bedrock.bosszp.view.part_shadow_popup.inner.view.BusinessView;

import zuo.biao.library.base.BaseAdapter;
import zuo.biao.library.model.Entry;

public class BusinessAdapter extends BaseAdapter<Entry<String,String>, BusinessView> {

    public BusinessAdapter(Activity context) {
        super(context);
    }

    @Override
    public BusinessView createView(int viewType, ViewGroup parent) {
        return new BusinessView(context,parent);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }
}
