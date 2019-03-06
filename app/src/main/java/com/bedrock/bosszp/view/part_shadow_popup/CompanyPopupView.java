package com.bedrock.bosszp.view.part_shadow_popup;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bedrock.bosszp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;

public class CompanyPopupView extends PartShadowPopupView {
    public CompanyPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.shadow_popup_company;
    }
}
