package com.recursosformacion.reloj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebRF extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_r_f);

        wv1 = (WebView)findViewById(R.id.wv1);
        wv1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        wv1.loadUrl("https://recursosformacion.com/wordpress/"  ) ;
        //wv1.loadUrl("https://google.com/"  ) ;
    }

    @Override
    public void onBackPressed()
    {
        if (wv1.canGoBack())
        {
            wv1.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}