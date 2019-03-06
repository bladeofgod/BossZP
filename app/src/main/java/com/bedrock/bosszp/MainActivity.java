package com.bedrock.bosszp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bedrock.bosszp.fragment.CompanyFragment;
import com.bedrock.bosszp.fragment.JobsFragment;
import com.bedrock.bosszp.fragment.MessageFragment;
import com.bedrock.bosszp.fragment.UserFragment;
import com.gyf.barlibrary.ImmersionBar;

import zuo.biao.library.base.BaseActivity;
import zuo.biao.library.base.BaseBottomTabActivity;

public class MainActivity extends BaseBottomTabActivity {

    public static Intent createIntent(Context context){
        return new Intent(context,MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this).init();

        initView();
        initData();
        initEvent();

    }

    @Override
    public void initView() {
        super.initView();

    }

    public static final String[] TABS_NAME = new String[]{
            "职位","公司","消息","我的"
    };

    @Override
    protected void selectTab(int position) {
        //tvBaseTitle.setText(TABS_NAME[position]);

    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    protected int[] getTabClickIds() {
        return new int[]{
                R.id.llBottomTabTab0,R.id.llBottomTabTab1,R.id.ivBottomTabTab2,R.id.llBottomTabTab3
        };
    }

    @Override
    protected int[][] getTabSelectIds() {
        return new int[][]{
                new int[]{R.id.ivBottomTabTab0,R.id.ivBottomTabTab1,R.id.ivBottomTabTab2,R.id.ivBottomTabTab3},
                new int[]{R.id.tvBottomTabTab0,R.id.tvBottomTabTab1,R.id.tvBottomTabTab2,R.id.tvBottomTabTab3}
        };
    }

    @Override
    public int getFragmentContainerResId() {
        return R.id.main_fragment_container;
    }

    @Override
    protected Fragment getFragment(int position) {
        switch (position){
            default:
                return JobsFragment.getInstance();
            case 1:
                return CompanyFragment.getInstance();
            case 2:
                return MessageFragment.getInstance();
            case 3:
                return UserFragment.getInstance();

        }
    }

    @Override
    public void initEvent() {
        super.initEvent();

    }
}
