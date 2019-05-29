package com.example.browserdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class BrowsingActivity extends AppCompatActivity {

    WebView webView;
    EditText searchWeb2;
    Button goBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing);

        Intent intentAddItem = getIntent();
        webView = findViewById(R.id.webViewId);
        String getUrl =intentAddItem.getStringExtra("url");
        String getUrlFromGrid =intentAddItem.getStringExtra("urlFromGrid");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadsImagesAutomatically(true);

        if(getUrl!=null){
            webView.loadUrl(getUrl);
        }
        else {
            webView.loadUrl(getUrlFromGrid);
        }



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else{
            Intent intent = new Intent(BrowsingActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
