package com.example.kotlincode.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {
    abstract fun getBinding(): ViewBinding

    abstract fun initView(savedInstanceState: Bundle?)

    protected lateinit var mBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getBinding()
        setContentView(mBinding.root)
        initView(savedInstanceState)
        Log.i("TAG", javaClass.simpleName)
    }


}