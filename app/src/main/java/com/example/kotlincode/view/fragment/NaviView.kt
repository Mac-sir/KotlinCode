package com.example.kotlincode.view.fragment

import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.bean.NaviData

interface NaviView {
    fun getDataSuccess(data:List<NaviData>)
    fun getDataFailed(error: String)
}