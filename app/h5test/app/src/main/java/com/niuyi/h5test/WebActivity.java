package com.niuyi.h5test;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

//    private static final String URL = "http://baidu.com/";
    private WebView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String path = getIntent().getStringExtra("path");

        TextView tv = (TextView)findViewById(R.id.id_tv);
        tv.setText(path);

        mView = (WebView)findViewById(R.id.id_web_view);
        WebSettings settings = mView.getSettings();
        settings.setJavaScriptEnabled(true);

        mView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mView.setWebChromeClient(new WebChromeClient());

        mView.loadUrl(path);
    }

    @Override
    public void onBackPressed() {
        if(mView.canGoBack()){
            mView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
