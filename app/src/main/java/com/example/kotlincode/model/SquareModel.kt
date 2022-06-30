package com.example.kotlincode.model

import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.BannerData
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.http.callback.BaseListCallback
import com.example.kotlincode.presenter.SquarePresenter

class SquareModel {

    fun getSquareList(page: Int, callback: SquarePresenter.OnSquareListListener) {
        DataManager.getSquareList(page, object : BaseCallback<BaseData> {
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