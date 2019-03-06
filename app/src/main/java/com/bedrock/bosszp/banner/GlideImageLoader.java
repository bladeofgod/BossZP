package com.bedrock.bosszp.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

import com.bedrock.bosszp.R;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).into(imageView);

    }
}
