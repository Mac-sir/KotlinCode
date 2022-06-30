package com.example.kotlincode.view.fragment

import com.example.kotlincode.http.bean.BaseData

interface NormalView {
    fun getDataSuccess(data:BaseData)
    fun getDataFailed(error: String)
}