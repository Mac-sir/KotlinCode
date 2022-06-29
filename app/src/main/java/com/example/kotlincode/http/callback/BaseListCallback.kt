package com.example.kotlincode.http.callback

interface BaseListCallback<T> {
    fun success(t: List<T>)
    fun fail(m: String){}
}