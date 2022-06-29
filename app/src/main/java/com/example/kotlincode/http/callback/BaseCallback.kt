package com.example.kotlincode.http.callback

interface BaseCallback<T> {
    fun success(t: T)
    fun fail(m: String){}
}