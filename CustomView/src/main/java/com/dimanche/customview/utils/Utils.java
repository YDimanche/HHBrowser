package com.dimanche.customview.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/30:06
 * desc   :
 * version: 1.0
 */
public class Utils {

    /**
     * 判断字符串是否为URL
     *
     * @param str 需要判断的String类型url
     * @return true:是URL；false:不是URL
     */
    public static boolean isHttpUrl(String str) {
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"//https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?"//ftp的user@  
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184  
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        return str.matches(regex);
    }

    /**
     * 通过scheme判断应用是否被安装
     *
     * @param mContext
     * @param url
     * @return
     */
    public static boolean checkUrlScheme(Context mContext, String url) {
        Uri uri = Uri.parse(url);//scheme
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return !activities.isEmpty();
    }

    /**
     * 根据scheme打开应用
     *
     * @param mContext
     * @param url
     */
    public static void openOtherApp(Context mContext, String url) {
        Log.e("openOtherApp", "openOtherApp: " + url);
        try {
            if (Utils.checkUrlScheme(mContext, url)) {
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                intent.setComponent(null);
                mContext.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("openOtherApp", "openOtherApp: ", e);
        }
    }
}
