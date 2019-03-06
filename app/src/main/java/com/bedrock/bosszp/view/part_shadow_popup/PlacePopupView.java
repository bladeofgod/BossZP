package com.bedrock.bosszp.view.part_shadow_popup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.adapter.PlaceAdapter;
import com.bedrock.bosszp.fragment.PlaceSelectorFragment;
import com.lxj.xpopup.impl.PartShadowPopupView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class PlacePopupView extends PartShadowPopupView {
    SoftReference<Context> softReference;
    FragmentManager fragmentManager;
    public PlacePopupView(@NonNull Context context,FragmentManager fragmentManager) {
        super(context);
        softReference = new SoftReference<Context>(context);
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.shadow_popup_place;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
//        List<String> strings = new ArrayList<>();
//        for (int i=0;i<30;i++){
//            strings.add("北京");
//        }
//
//        RecyclerView recyclerView = findViewById(R.id.rv_place);
//
//        PlaceAdapter adapter = new PlaceAdapter(softReference.get(),strings);
//        recyclerView.setLayoutManager(new LinearLayoutManager(softReference.get()));
//        recyclerView.setAdapter(adapter);

        FragmentManager fragmentManager = this.fragmentManager;
        FragmentTransaction tf = fragmentManager.beginTransaction();
        tf.add(R.id.place_fg_container,PlaceSelectorFragment.getInstance());
        tf.show(PlaceSelectorFragment.getInstance());
        tf.commit();
    }
}
