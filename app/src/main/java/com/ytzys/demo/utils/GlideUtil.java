package com.ytzys.demo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ytzys on 2017/2/15.
 */

public class GlideUtil {

    public static void loadImg(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
