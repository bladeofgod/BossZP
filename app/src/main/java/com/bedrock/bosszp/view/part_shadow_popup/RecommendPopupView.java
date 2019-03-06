package com.bedrock.bosszp.view.part_shadow_popup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.bedrock.bosszp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;

public class RecommendPopupView extends PartShadowPopupView {
    public RecommendPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.shadow_popup_recommend;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();

        findViewById(R.id.btnClose).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
