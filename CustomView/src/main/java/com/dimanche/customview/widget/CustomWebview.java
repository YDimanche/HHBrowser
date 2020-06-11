package com.dimanche.customview.widget;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/211:58
 * desc   : 自定义webview
 * version: 1.0
 */
public class CustomWebview extends WebView {
    public CustomWebClient mCustomWebClient;
    private Context mContext;
    private static final int API = Build.VERSION.SDK_INT;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public CustomWebview(Context context) {
        super(context);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public CustomWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init(Context mContext) {
        this.mContext = mContext;
        WebSettings webSetting = this.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
//        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSetting.setLightTouchEnabled(true);
        //处理http和https共存的问题
        if (API >= Build.VERSION_CODES.LOLLIPOP) {
            webSetting.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        } else if (API >= Build.VERSION_CODES.LOLLIPOP) {
            // We're in Incognito mode, reject
            webSetting.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        }
        
        mCustomWebClient = new CustomWebClient(mContext);
        setWebChromeClient(new CustomWebChromeClient());
        setWebViewClient(mCustomWebClient);

    }


}
