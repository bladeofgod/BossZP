package com.bedrock.bosszp.adapter;

import android.app.Activity;
import android.view.ViewGroup;

import com.bedrock.bosszp.model.JobBean;
import com.bedrock.bosszp.view_holder.JobsViewHolder;

import zuo.biao.library.base.BaseAdapter;

public class JobsAdapter extends BaseAdapter<JobBean, JobsViewHolder> {

    public JobsAdapter(Activity context){super(context);}

    @Override
    public JobsViewHolder createView(int viewType, ViewGroup parent) {
        return new JobsViewHolder(context,parent);
    }


}
