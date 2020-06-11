package com.dimanche.customview.utils;

import android.app.Activity;
import android.view.ViewGroup;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/5/3123:16
 * desc   :
 * version: 1.0
 */
public class SystemUtils {
    /**
     * 开启硬件加速
     *
     * @param mActivity
     */
    public static void setFlagHardwareAccelerated(Activity mActivity) {
        try {
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11) {
                mActivity.getWindow()
                        .setFlags(
                                android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                                android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 充满父布局
     */
    public static final ViewGroup.LayoutParams MATCH_PARENT = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT);
}
