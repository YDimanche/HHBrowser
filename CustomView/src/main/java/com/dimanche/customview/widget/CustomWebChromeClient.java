package com.dimanche.customview.widget;

import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * author : Dimanche
 * e-mail : 805894501@qq.com
 * date   : 2020/6/222:01
 * desc   :
 * version: 1.0
 */
public class CustomWebChromeClient extends WebChromeClient {


    /**
     * 确认对话框
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {

        return super.onJsConfirm(view, url, message, result);
    }

    /**
     * 自定义dialog
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    /**
     * 全屏播放
     * @param view
     * @param callback
     */
    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        super.onShowCustomView(view, callback);
    }

    /**
     * 全屏播放
     */
    @Override
    public void onHideCustomView() {
        super.onHideCustomView();
    }
}
