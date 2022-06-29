package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.BannerData
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.model.MainModel
import com.example.kotlincode.presenter.MainPresenter.OnBannerListener
import com.example.kotlincode.view.MainView

class MainPresenterImpl(private val mainView: MainView) : MainPresenter.OnMainListListener,
    OnBannerListener {

    private val mainModel = MainModel()

    override fun getList(page: Int) {
        mainModel.getList(page, this)
    }

    override fun getListSuccess(data: BaseData) {
        mainView.getMainSuccess(data)
    }

    override fun getListFailed(error: String) {
        mainView.getMainFailed(error)
    }

    override fun getBanner() {
        mainModel.getBanner(this)
    }

    override fun getBannerSuccess(bannerData: List<BannerData>) {
        mainView.getBannerSuccess(bannerData)
    }

    override fun getBannerFailed(error: String) {
        mainView.getBannerFailed(error)
    }

}