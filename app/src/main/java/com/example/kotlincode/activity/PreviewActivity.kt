package com.example.kotlincode.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.viewbinding.ViewBinding
import com.example.kotlincode.R
import com.example.kotlincode.databinding.ActivityWebBinding

class PreviewActivity : BaseActivity() {
    override fun getBinding(): ViewBinding = ActivityWebBinding.inflate(layoutInflater)

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView(savedInstanceState: Bundle?) {
        val url = intent.data
        val binding = mBinding as ActivityWebBinding
        binding.web.run {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            loadUrl(url.toString())
        }
    }
}