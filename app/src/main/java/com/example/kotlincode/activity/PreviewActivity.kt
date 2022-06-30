package com.example.kotlincode.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.viewbinding.ViewBinding
import com.example.kotlincode.R
import com.example.kotlincode.databinding.ActivityWebBinding

class PreviewActivity : BaseActivity() {
    override fun getBinding(): ViewBinding = ActivityWebBinding.inflate(layoutInflater)
    private lateinit var binding: ActivityWebBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView(savedInstanceState: Bundle?) {
        val url = intent.data
        binding = mBinding as ActivityWebBinding
        binding.web.run {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            settings.setSupportMultipleWindows(true)
            settings.javaScriptCanOpenWindowsAutomatically = true //允许js弹窗
            Log.i("TAG", "url数据：" + url.toString())
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    val uri = request?.url as Uri
                    uri.scheme?.let {
                        Log.i("TAG", "url数据>" + it)
                        when (it) {
                            "https" -> return false
                            "snssdk2606" -> return true
                            "jianshu" -> return true
                            else -> {}
                        }
                    }
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }
            loadUrl(url.toString())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.web.canGoBack()){
            binding.web.goBack()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (binding.web.canGoBack()){
                binding.web.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}