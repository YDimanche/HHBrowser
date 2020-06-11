package com.dimanche.customview.model.bean;

import android.graphics.Bitmap;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/211:43
 * desc   :网页实体类
 * version: 1.0
 */
public class WebpageBean {

    /**
     * 网页图标
     */
    private Bitmap mBitmap;

    /**
     * 网页标题
     */
    private String mTitle;

    /**
     * 网页网址
     */
    private String url;

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
