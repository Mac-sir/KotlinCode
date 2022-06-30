package com.example.kotlincode.view.fragment

import com.example.kotlincode.http.bean.TreeListData

interface SystemView {
    fun getDataSuccess(data: List<TreeListData>)
    fun getDataFailed(error: String)
}