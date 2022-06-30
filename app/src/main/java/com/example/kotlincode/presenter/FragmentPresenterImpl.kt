package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.model.FragmentModel
import com.example.kotlincode.view.fragment.NormalView

class FragmentPresenterImpl(private val view: NormalView) :
    FragmentPresenter.OnChaptersContentListener,
    FragmentPresenter.OnProjectContentListener {

    private val fragmentModel = FragmentModel()

    override fun getChapterContent(id: Int, page: Int) {
        fragmentModel.getChapterContent(id, page, this)
    }

    override fun getChapterContentSuccess(data: BaseData) {
        view.getDataSuccess(data)
    }

    override fun getChapterContentFailed(error: String) {
        view.getDataFailed(error)
    }

    override fun getProjectContent(id: Int, page: Int) {
        fragmentModel.getProjectContent(id, page, this)
    }

    override fun getProjectContentSuccess(data: BaseData) {
        view.getDataSuccess(data)
    }

    override fun getProjectContentFailed(error: String) {
        view.getDataFailed(error)
    }
}