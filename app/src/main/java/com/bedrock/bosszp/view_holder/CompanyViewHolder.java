package com.bedrock.bosszp.view_holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.model.CompanyBean;
import com.bumptech.glide.Glide;

import zuo.biao.library.base.BaseView;

public class CompanyViewHolder extends BaseView<CompanyBean> implements View.OnClickListener {


    public CompanyViewHolder(Activity context, ViewGroup parent) {
        super(context, R.layout.rv_item_company_card, parent);
    }

    private ImageView avatar;
    private TextView tvName,tvLocation,tvAttr,tvWanted;

    @Override
    public View createView() {

        tvName = findView(R.id.tv_com_name);
        tvLocation = findView(R.id.tv_com_location);
        avatar = findView(R.id.iv_com_avatar);
        tvWanted = findView(R.id.tv_wanted_detail);

        return super.createView();
    }

    @Override
    public void bindView(CompanyBean data_) {
        super.bindView(data_ != null ? data_ : new CompanyBean());

        tvName.setText(data.getName());
        tvLocation.setText(data.getLocation());
        tvWanted.setText(data.getWantedDetail());
        Glide.with(context).load(R.mipmap.ic_launcher).into(avatar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                showShortToast("点击了 item");
                break;
        }

    }
}
