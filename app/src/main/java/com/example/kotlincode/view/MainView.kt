package com.example.kotlincode.view

import com.example.kotlincode.http.bean.BannerData
import com.example.kotlincode.http.bean.BaseData

interface MainView {
    fun getBannerSuccess(data:List<BannerData>)
    fun getBannerFailed(error:String)

    fun getMainSuccess(data:BaseData)
    fun getMainFailed(error:String)
}