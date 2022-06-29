package com.example.kotlincode.activity

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.kotlincode.R
import com.example.kotlincode.databinding.ActivityLoginBinding
import com.example.kotlincode.http.bean.LoginData
import com.example.kotlincode.presenter.LoginPresenterImpl
import com.example.kotlincode.util.toast
import com.example.kotlincode.view.LoginView

class LoginActivity : BaseActivity(), LoginView {
    override fun getBinding(): ViewBinding = ActivityLoginBinding.inflate(layoutInflater)
    private val loginPresenter: LoginPresenterImpl by lazy {
        LoginPresenterImpl(this)
    }

    private var loginBinding: ActivityLoginBinding? = null

    override fun initView(savedInstanceState: Bundle?) {
        loginBinding = (mBinding as ActivityLoginBinding)
        loginBinding!!.back.setOnClickListener(onClickListener)
        loginBinding!!.btnLogin.setOnClickListener(onClickListener)
    }

    override fun loginSuccess(result: LoginData) {
        finish()
    }

    override fun loginFail(error: String?) {
        error?.let { toast(it) }
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.back -> {
                onBackPressed()
            }
            R.id.btn_login -> {
                val user = loginBinding!!.inputName.text.toString()
                val password = loginBinding!!.inputName.text.toString()
                loginPresenter.loginWan(user, password)
            }
        }
    }

}