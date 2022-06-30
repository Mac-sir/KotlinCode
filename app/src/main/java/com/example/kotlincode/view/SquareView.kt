package com.example.kotlincode.view

import com.example.kotlincode.http.bean.BaseData

interface SquareView {

    fun getListSuccess(data: BaseData)
    fun getListFailed(error: String)
}