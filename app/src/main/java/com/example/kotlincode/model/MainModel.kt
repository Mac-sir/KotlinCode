package com.example.kotlincode.model

import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.BannerData
import com.example.kotlincode.http.bean.BaseBean
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.http.callback.BaseListCallback
import com.example.kotlincode.presenter.MainPresenter

class MainModel {

    fun getBanner(callback: MainPresenter.OnBannerListener) {
        DataManager.getBanner(object : BaseListCallback<BannerData> {
            override fun success(t: List<BannerData>) {
                callback.getBannerSuccess(t)
            }

            override fun fail(m: String) {
                super.fail(m)
                callback.getBannerFailed(m)
            }
        })
    }

    fun getList(page: Int, callback: MainPresenter.OnMainListListener) {
        DataManager.getList(page, object : BaseCallback<BaseData> {
            override fun success(t: BaseData) {
                callback.getListSuccess(t)
            }

            override fun fail(m: String) {
                super.fail(m)
                callback.getListFailed(m)
            }
        })
    }
}