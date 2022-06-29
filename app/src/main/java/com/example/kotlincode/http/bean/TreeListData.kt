package com.example.kotlincode.http.bean

data class TreeListData(
    var id: Int,
    var name: String,
    var courseId: Int,
    var parentChapterId: Int,
    var order: Int,
    var visible: Int,
    var children: List<Children>?
) {
    data class Children(
        var id: Int,
        var name: String,
        var courseId: Int,
        var parentChapterId: Int,
        var order: Int,
        var visible: Int,
        var children: List<Children>?
    )
}
