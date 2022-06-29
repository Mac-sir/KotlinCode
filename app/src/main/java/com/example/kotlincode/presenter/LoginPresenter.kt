package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.LoginData

interface LoginPresenter {

    interface OnLoginListener {
        fun loginWan(username: String, password: String)
        fun loginSuccess(result: LoginData)
        fun loginFailed(error: String?)
    }

    interface OnRegisterListener {
        fun registerWan(username: String, password: String, rePassWord: String)
        fun registerSuccess(result: LoginData)
        fun registerFailed(error: String?)
    }
}