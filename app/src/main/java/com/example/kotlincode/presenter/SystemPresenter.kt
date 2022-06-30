package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.TreeListData

interface SystemPresenter {
    interface OnSystemListener {
        fun getSystemList()
        fun getListSuccess(data: List<TreeListData>)
        fun getListFailed(error: String)
    }
}