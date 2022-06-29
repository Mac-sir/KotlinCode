package com.example.kotlincode.http.bean

data class BannerData(
    var id: Int,
    var url: String,
    var imagePath: String,
    var title: String,
    var desc: String,
    var isVisible: Int,
    var order: Int,
    var type: Int
)
