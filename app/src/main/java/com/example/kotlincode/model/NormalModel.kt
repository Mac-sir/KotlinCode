package com.example.kotlincode.model

import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.http.callback.BaseListCallback
import com.example.kotlincode.presenter.NormalPresenter

class NormalModel {
    fun getChaptersList(callback: NormalPresenter.OnPublicListener) {
        DataManager.getChaptersList(object : BaseListCallback<TreeListData> {
            override fun success(t: List<TreeListData>) {
                callback.getDataSuccess(t)
            }
        })
    }

    fun getProjectList(callback: NormalPresenter.OnPublicListener) {
        DataManager.getProjectList(object : BaseListCallback<TreeListData> {
            override fun success(t: List<TreeListData>) {
                callback.getDataSuccess(t)
            }
        })
    }
}