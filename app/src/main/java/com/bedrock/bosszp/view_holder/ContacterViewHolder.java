package com.bedrock.bosszp.view_holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.model.ContacterBean;
import com.bumptech.glide.Glide;

import zuo.biao.library.base.BaseView;

public class ContacterViewHolder extends BaseView<ContacterBean> {
    public ContacterViewHolder(Activity context, ViewGroup parent) {
        super(context, R.layout.rv_item_msg_chat, parent);
    }

    private ImageView ivAvatar;
    private TextView tvName,tvMsg,tvTime;

    @Override
    public View createView() {

        ivAvatar = findView(R.id.iv_chat_avatar);
        tvName = findView(R.id.tv_mgr_name);
        tvMsg = findView(R.id.tv_mgr_msg);
        tvTime = findView(R.id.tv_msg_time);

        return super.createView();
    }

    @Override
    public void bindView(ContacterBean data_) {
        super.bindView(data_!= null ?data_ : new ContacterBean());

        Glide.with(context).load(R.mipmap.ic_launcher_round).into(ivAvatar);

        tvName.setText(data.getMgrNmae());
        tvMsg.setText(data.getMgrMsg());
        tvTime.setText(data.getChatDate());

    }
}
