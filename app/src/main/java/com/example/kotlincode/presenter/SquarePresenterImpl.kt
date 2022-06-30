package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.model.SquareModel
import com.example.kotlincode.view.SquareView

class SquarePresenterImpl(private val squareView: SquareView) : SquarePresenter.OnSquareListListener {

    val squareModel = SquareModel()

    override fun getSquareList(page: Int) {
        squareModel.getSquareList(page,this)
    }

    override fun getListSuccess(data: BaseData) {
        squareView.getListSuccess(data)
    }

    override fun getListFailed(error: String) {
        squareView.getListFailed(error)
    }
}