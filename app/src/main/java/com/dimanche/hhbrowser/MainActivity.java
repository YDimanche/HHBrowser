package com.dimanche.hhbrowser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.BarUtils;
import com.dimanche.customview.utils.SystemUtils;
import com.dimanche.customview.utils.Utils;
import com.dimanche.customview.widget.CustomWebClient;
import com.dimanche.customview.widget.CustomWebview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CustomWebClient.CustomWebClientCallBack {
    private Context mContext;
    private CustomWebview mWebview;
    private String url = "https://www.baidu.com";

    @BindView(R.id.webview_container)
    public FrameLayout webviewContainer;
    @BindView(R.id.search_title_edit)
    public EditText searchTitleEdit;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //开启硬件加速
        SystemUtils.setFlagHardwareAccelerated(this);
        //设置状态栏
        BarUtils.setStatusBarColor(this, R.color.white);
        BarUtils.setStatusBarLightMode(this, true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mWebview = new CustomWebview(mContext);
        mWebview.mCustomWebClient.setCustomWebClientCallBack(this::url);
        webviewContainer.addView(mWebview, SystemUtils.MATCH_PARENT);
        mWebview.loadUrl(url);
    }

    @OnClick({R.id.search_title_go, R.id.btnBack1, R.id.btnForward1, R.id.btnMore, R.id.btnHome1})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_title_go:
                url = searchTitleEdit.getText() == null ? "" : searchTitleEdit.getText().toString();
                if (Utils.isHttpUrl(url)) {
                    mWebview.loadUrl(url);
                } else {
                    url = "https://www.baidu.com/s?ie=UTF-8&wd=" + url;
                    mWebview.loadUrl(url);
                }
                break;
            case R.id.btnBack1:
                mWebview.goBack();
                break;

            case R.id.btnForward1:
                mWebview.goForward();
                break;

            case R.id.btnMore:

                break;

            case R.id.btnHome1:
                mWebview.loadUrl("https://www.baidu.com");
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebview != null && mWebview.canGoBack()) {
                mWebview.goBack();
                return true;
            } else
                return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void url(String url) {
        searchTitleEdit.setText(url);
    }
}