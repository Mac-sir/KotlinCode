package com.example.kotlincode.http.bean

data class NaviData(
    var cid: Int,
    var name: String,
    var articles: List<Data>?
) {
    data class Data(
        var author: String,
        var chapterId: Int,
        var chapterName: String,
        var id: Int,
        var link: String,
        var title: String,
    )
}
