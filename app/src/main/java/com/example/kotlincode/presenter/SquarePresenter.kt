package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.BaseData

interface SquarePresenter {
    interface OnSquareListListener {
        fun getSquareList(page: Int = 0)
        fun getListSuccess(data: BaseData)
        fun getListFailed(error: String)
    }
}