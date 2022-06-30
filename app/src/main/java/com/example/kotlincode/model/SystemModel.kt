package com.example.kotlincode.model

import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.http.callback.BaseListCallback
import com.example.kotlincode.presenter.NormalPresenter
import com.example.kotlincode.presenter.SystemPresenter

class SystemModel {
    fun getTypeTreeList(callback: SystemPresenter.OnSystemListener) {
        DataManager.getTypeTreeList(object : BaseListCallback<TreeListData> {
            override fun success(t: List<TreeListData>) {
                callback.getListSuccess(t)
            }
        })
    }
}