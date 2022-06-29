package com.example.kotlincode.util

import android.content.Context
import android.widget.Toast
import com.example.kotlincode.Constant

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