package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.LoginData
import com.example.kotlincode.model.LoginModel
import com.example.kotlincode.view.LoginView

class LoginPresenterImpl(val loginView: LoginView) : LoginPresenter.OnLoginListener,
    LoginPresenter.OnRegisterListener {

    private val loginModel: LoginModel = LoginModel()

    override fun loginWan(username: String, password: String) {
        loginModel.loginWan(username, password, this)
    }

    override fun loginSuccess(result: LoginData) {
        loginView.loginSuccess(result)
    }

    override fun loginFailed(error: String?) {
        loginView.loginFail(error)
    }

    override fun registerWan(username: String, password: String, rePassWord: String) {
        TODO("Not yet implemented")
    }

    override fun registerSuccess(result: LoginData) {
        TODO("Not yet implemented")
    }

    override fun registerFailed(error: String?) {
        TODO("Not yet implemented")
    }
}