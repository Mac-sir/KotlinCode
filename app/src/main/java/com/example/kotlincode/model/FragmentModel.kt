package com.example.kotlincode.model

import android.util.Log
import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.presenter.FragmentPresenter

class FragmentModel {
    fun getChapterContent(
        id: Int,
        page: Int,
        callback: FragmentPresenter.OnChaptersContentListener
    ) {
        DataManager.getChaptersContentList(id, page, object : BaseCallback<BaseData> {
            override fun success(t: BaseData) {
                callback.getChapterContentSuccess(t)
            }
        })
    }

    fun getProjectContent(
        id: Int,
        page: Int,
        callback: FragmentPresenter.OnProjectContentListener
    ) {
        DataManager.getProjectContentList(id, page, object : BaseCallback<BaseData> {
            override fun success(t: BaseData) {
                callback.getProjectContentSuccess(t)
            }
        })
    }

    fun getTreeChildren(
        id: Int,
        page: Int,
        callback: FragmentPresenter.OnTreeChildrenListener
    ) {
        DataManager.getTreeChildrenList(id, page, object : BaseCallback<BaseData> {
            override fun success(t: BaseData) {
                callback.getTreeChildrenSuccess(t)
            }
        })
    }
}