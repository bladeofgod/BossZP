package com.bedrock.bosszp.application;

import com.gyf.barlibrary.ImmersionBar;

import zuo.biao.library.base.BaseApplication;

public class BaseApp extends BaseApplication {

    private static BaseApp context;
    public static BaseApp getInstance(){return context;}

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }
}
