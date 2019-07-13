package com.responsi.mvp.handler;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideHandler {

    public static void setImg(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .into(view);
    }
}
