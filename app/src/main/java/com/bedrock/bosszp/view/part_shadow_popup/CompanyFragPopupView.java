package com.bedrock.bosszp.view.part_shadow_popup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bedrock.bosszp.R;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.ref.SoftReference;

public class CompanyFragPopupView extends PartShadowPopupView {
    SoftReference<Context> reference;
    String[] tags = new String[]{
            "apple","android","application","java","IOS","C/C++","HTML",
            "Javascript"
    };

    public CompanyFragPopupView(@NonNull Context context) {
        super(context);
        reference = new SoftReference<>(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.shadow_popup_com_fragment;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();

        final TagFlowLayout flowLayout = findViewById(R.id.tag_fl);
        flowLayout.setAdapter(new TagAdapter<String>(tags) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(reference.get())
                        .inflate(R.layout.tag_s_p_company_f,flowLayout,false);
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                Toast.makeText(reference.get(),"select " +tags[position],Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(R.color.blue));
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                view.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

    }
}
