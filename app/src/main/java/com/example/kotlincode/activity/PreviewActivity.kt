package com.example.kotlincode.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import com.example.kotlincode.R

class PreviewActivity :Activity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val url = intent.data
        val webView:WebView = findViewById(R.id.web)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url.toString())
    }
}