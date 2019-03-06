package com.bedrock.bosszp.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bedrock.bosszp.MainActivity;
import com.bedrock.bosszp.R;

import zuo.biao.library.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        initData();
        initEvent();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toActivity(MainActivity.createIntent(SplashActivity.this));
                finish();
            }
        },1500);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
