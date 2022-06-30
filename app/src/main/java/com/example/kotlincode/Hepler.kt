package com.example.kotlincode

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.kotlincode.activity.BaseActivity
import com.example.kotlincode.activity.PreviewActivity
import com.example.kotlincode.activity.main.NormalActivity

/**
 * 扩展函数  Class.mothod(参数：类型)
 */
fun Context.toast(content: String) {
    Constant.showToast?.apply {
        setText(content)
        show()
    } ?: run {
        Toast.makeText(this.applicationContext, content, Toast.LENGTH_SHORT).apply {
            Constant.showToast = this
        }.show()
    }
}

/**
 * webView 预览
 * 静态方法创建
 * 顶层方法 作用域在全局
 */
fun startPreview(activity: FragmentActivity, uri: String) {
    val intent = Intent(activity, PreviewActivity::class.java)
    intent.data = Uri.parse(uri)
    activity.startActivity(intent)
}

/**
 * 意图跳转
 * 静态方法创建
 * 顶层方法 作用域在全局
 */
fun startAction(activity: BaseActivity, title: String) {
    val intent = Intent(activity, NormalActivity::class.java)
    intent.putExtra(Constant.COMMON_TITLE_KEY, title)
    activity.startActivity(intent)
}