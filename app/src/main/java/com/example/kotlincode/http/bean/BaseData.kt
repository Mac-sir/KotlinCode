package com.example.kotlincode.http.bean

data class BaseData(
    var offset: Int,
    var size: Int,
    var total: Int,
    var pageCount: Int,
    var curPage: Int,
    var over: Boolean,
    var datas: List<BaseDatas>?
)