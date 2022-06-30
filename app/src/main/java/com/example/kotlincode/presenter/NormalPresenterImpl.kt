package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.model.NormalModel
import com.example.kotlincode.view.NormalView

class NormalPresenterImpl(private val normalView: NormalView) :
    NormalPresenter.OnChaptersListener, NormalPresenter.OnProjectListener,
    NormalPresenter.OnPublicListener {
    private val normalModel = NormalModel()
    override fun getChaptersList() {
        normalModel.getChaptersList(this)
    }

    override fun getProjectList() {
        normalModel.getProjectList(this)
    }

    override fun getDataSuccess(chapters: List<TreeListData>) {
        normalView.getDataSuccess(chapters)
    }

    override fun getDataFailed(error: String) {
        normalView.getDataFailed(error)
    }
}