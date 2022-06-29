package com.example.kotlincode.http.bean

data class HotKeyData(
    var errorCode: Int,
    var errorMsg: String?,
    var data: List<Data>?
) {
    data class Data(
        var id: Int,
        var name: String,
        var link: Any,
        var visible: Int,
        var order: Int
    )
}