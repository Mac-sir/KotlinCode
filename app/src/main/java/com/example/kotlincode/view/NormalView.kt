package com.example.kotlincode.view

import com.example.kotlincode.http.bean.TreeListData

interface NormalView {
    fun getDataSuccess(data: List<TreeListData>)
    fun getDataFailed(error: String)
}