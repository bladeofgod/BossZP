package com.bedrock.bosszp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bedrock.bosszp.R;
import com.bedrock.bosszp.fragment.message.ChatFragment;
import com.bedrock.bosszp.fragment.message.ReactionFragment;

import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.base.BaseTabFragment;

public class MessageFragment extends BaseTabFragment {

    public static MessageFragment getInstance(){
        return new MessageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState,R.layout.fragment_message);

        initView();
        initData();
        initEvent();

        return view;

    }

    @Override
    public void initView() {
        super.initView();

    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    protected String[] getTabNames() {
        return new String[]{"聊天","互动"};
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position){
            default:
                return ChatFragment.getInstance();
            case 1:
                return ReactionFragment.getInstance();
        }
    }

    @Override
    public void initEvent() {
        super.initEvent();

    }
}
