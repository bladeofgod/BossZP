package com.bedrock.bosszp.adapter.popup_place_business;

import android.content.Context;
import android.graphics.Color;

import java.lang.ref.SoftReference;
import java.util.List;

import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;

public class VerticalTabAdapter implements TabAdapter {

    private List<String> titles;
    public VerticalTabAdapter(List<String> titleList,Context context) {
        titles = titleList;

    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public ITabView.TabBadge getBadge(int position) {
        return null;
    }

    @Override
    public ITabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public ITabView.TabTitle getTitle(int position) {
        return new ITabView.TabTitle.Builder()
                .setContent(titles.get(position))
                .setTextColor(Color.BLUE,Color.BLACK)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }
}
