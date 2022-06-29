package com.example.kotlincode.http.bean

data class ArticleListData(
    var errorCode: Int,
    var errorMsg: String?,
    var data: BaseData
)