package com.example.kotlincode.view

import com.example.kotlincode.http.bean.LoginData

interface LoginView {
    fun loginSuccess(result: LoginData)
    fun loginFail(error: String?)
}