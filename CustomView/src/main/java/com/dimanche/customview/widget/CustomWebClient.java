package com.dimanche.customview.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;


import com.dimanche.customview.utils.Utils;

import java.net.URISyntaxException;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/222:25
 * desc   :
 * version: 1.0
 */
public class CustomWebClient extends WebViewClient {

    private Context mContext;
    private CustomWebClientCallBack customWebClientCallBack;

    public void setCustomWebClientCallBack(CustomWebClientCallBack customWebClientCallBack) {
        this.customWebClientCallBack = customWebClientCallBack;
    }

    public CustomWebClient(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 对将要加载的url进行处理
     *
     * @param view
     * @param url
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, final String url) {
        customWebClientCallBack.url(url);
        if (!Utils.isHttpUrl(url)) {
            new AlertDialog.Builder(mContext).setTitle("提示")
                    .setMessage("网页请求打开第三方应用")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utils.openOtherApp(mContext, url);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).create().show();
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        //在这里可以监听到要加载的资源URL
        Log.e("onLoadResource", "onLoadResource: " + url);
    }

    public interface CustomWebClientCallBack {
        void url(String url);
    }
}
