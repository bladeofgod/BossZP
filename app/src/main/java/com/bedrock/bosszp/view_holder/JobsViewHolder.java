package com.bedrock.bosszp.view_holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.model.JobBean;

import zuo.biao.library.base.BaseView;

public class JobsViewHolder extends BaseView<JobBean> implements View.OnClickListener {

    public JobsViewHolder(Activity context, ViewGroup parent){
        super(context, R.layout.rv_item_job_card,parent);
    }

    private TextView tvJobName,tvComName,tvSalary,tvRecruiter;


    @Override
    public View createView() {
        tvJobName = findView(R.id.tv_job_name,this);
        tvComName = findView(R.id.tv_company_name,this);
        tvSalary = findView(R.id.tv_salary,this);
        tvRecruiter = findView(R.id.tv_recruiter,this);


        return super.createView();
    }

    @Override
    public void bindView(JobBean data_) {
        super.bindView(data_ != null ?data_: new JobBean());

        tvJobName.setText(data_.getJobName());
        tvComName.setText(data_.getCompanyName());
        tvSalary.setText(data_.getSalary());
        tvRecruiter.setText(data_.getRecruiter());

    }

    @Override
    public void onClick(View v) {

    }
}
