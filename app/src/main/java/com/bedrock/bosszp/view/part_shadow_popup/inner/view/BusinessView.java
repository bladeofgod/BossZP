package com.bedrock.bosszp.view.part_shadow_popup.inner.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bedrock.bosszp.R;

import zuo.biao.library.base.BaseView;
import zuo.biao.library.model.Entry;
import zuo.biao.library.util.StringUtil;

public class BusinessView extends BaseView<Entry<String,String>> implements View.OnClickListener {


    public BusinessView(Activity context, ViewGroup viewGroup) {
        super(context, R.layout.popup_place_business_right,viewGroup);
    }


    private TextView textView;
    @Override
    public View createView() {

        textView = findView(R.id.tv_item,this);
        return super.createView();
    }

    @Override
    public void bindView(Entry<String, String> data_) {
        super.bindView(data_ != null ? data_ : new Entry<String, String>());
        textView.setText(StringUtil.getTrimedString(data.value));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_item:
                showShortToast(data.getValue());
                break;
        }

    }
}











