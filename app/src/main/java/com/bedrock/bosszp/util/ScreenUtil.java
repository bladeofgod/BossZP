package com.bedrock.bosszp.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ScreenUtil {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getScreenHeightPx(Context context){
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        if (windowManager != null){
            windowManager.getDefaultDisplay().getRealMetrics(dm);
            return dm.heightPixels;
        }
        return 0;
    }

}
