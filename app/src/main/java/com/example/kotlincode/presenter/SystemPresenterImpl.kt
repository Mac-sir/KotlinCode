package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.model.SystemModel
import com.example.kotlincode.view.fragment.SystemView

class SystemPresenterImpl(private val systemView: SystemView) :
    SystemPresenter.OnSystemListener {

    val systemModel = SystemModel()

    override fun getSystemList() {
        systemModel.getTypeTreeList(this)
    }

    override fun getListSuccess(data: List<TreeListData>) {
        systemView.getDataSuccess(data)
    }

    override fun getListFailed(error: String) {
        systemView.getDataFailed(error)
    }
}