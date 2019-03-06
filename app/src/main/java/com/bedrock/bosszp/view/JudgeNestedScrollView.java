package com.bedrock.bosszp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class JudgeNestedScrollView extends NestedScrollView {

    private boolean isNeedScroll = true;
    private float xDistance,yDistance,xLast,yLast;
    private int scaledTouchSlop;


    public JudgeNestedScrollView(@NonNull Context context) {
        super(context,null);
    }

    public JudgeNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public JudgeNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //它获得的是触发移动事件的最短距离，如果小于这个距离就不触发移动控件，
        // 如viewpager就是用这个距离来判断用户是否翻页
        scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
                case MotionEvent.ACTION_MOVE:
                    final float curX= ev.getX();
                    final float curY = ev.getY();

                    xDistance += Math.abs(curX - xLast);
                    yDistance += Math.abs(curY - yLast);

                    xLast = curX;
                    yLast = curY;

                    return !(xDistance>=yDistance || yDistance<scaledTouchSlop) && isNeedScroll;

        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setNeedScroll(boolean isNeedScroll) {
        this.isNeedScroll = isNeedScroll;
    }
}














