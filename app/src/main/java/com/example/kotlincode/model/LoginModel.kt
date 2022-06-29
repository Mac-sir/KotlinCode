package com.example.kotlincode.model

import com.example.kotlincode.http.DataManager
import com.example.kotlincode.http.bean.LoginData
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.presenter.LoginPresenter

class LoginModel {
    fun loginWan(
        userName: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        DataManager.loginWan(userName,password,object : BaseCallback<LoginData>{
            override fun success(t: LoginData) {
                onLoginListener.loginSuccess(t)
            }

            override fun fail(m: String) {
                onLoginListener.loginFailed(m)
            }
        })
    }

}