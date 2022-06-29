package com.example.kotlincode.http

import com.example.kotlincode.Constant
import com.example.kotlincode.util.SPUtil
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

/**
 * 搭建Mvp+Retrofit+RxJava的请求架构
 * */
object RequestHelp {
    private const val CONTENT_PRE = "OkHttp: "
    private const val SAVE_USER_LOGIN_KEY = "user/login"
    private const val SAVE_USER_REGISTER_KEY = "user/register"
    private const val SET_COOKIE_KEY = "set-cookie"
    private const val COOKIE_NAME = "Cookie"

    val retrofitService = getService(Constant.baseURL, RetrofitService::class.java)

    private fun getService(uri: String, service: Class<RetrofitService>): RetrofitService {
        return create(uri).create(service)
    }

    private fun create(uri: String): Retrofit {
        //添加拦截器做Cookies持久化
        val okHttpClient = OkHttpClient.Builder().apply {
            //请求时添加
            addInterceptor {
                val request = it.request()
                val builder = request.newBuilder()
                val domain = request.url().host()
                if (domain.isEmpty()) {
                    val domainSp: String by SPUtil(domain, "")
                    val cookie: String = if (domainSp.isEmpty()) "" else domainSp
                    if (cookie.isNotEmpty()) {
                        builder.addHeader(COOKIE_NAME, cookie)
                    }
                }
                it.proceed(builder.build())
            }
            //返回时保存
            addInterceptor {
                val request = it.request()
                val response = it.proceed(request)
                val uri = it.request().url().toString()
                val domain = it.request().url().host()
                if ((uri.contains(SAVE_USER_LOGIN_KEY) || uri.contains(SAVE_USER_REGISTER_KEY))
                    && response.headers(SET_COOKIE_KEY).isNotEmpty()
                ) {
                    val cookies = response.headers(SET_COOKIE_KEY)
                    val cookie = encodeCookie(cookies)
                    saveCookie(uri, domain, cookie)
                }
                it.proceed(request)
            }
        }
        return Retrofit.Builder()
            .baseUrl(uri)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    /**
     * 转换cookie数据类型
     */
    private fun encodeCookie(cookies: List<String>): String {
        var sb = StringBuilder()
        var list = mutableListOf<String>()
        for (cookie in cookies) {
            val arr = cookie.split(";")
            for (str in arr) {
                if (list.contains(str)) {
                    continue
                }
                list.add(str)
            }
        }
        for (cookie in list) {
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }
        return sb.toString()
    }

    /**
     * 保存 cookie 2 SharePreferences
     */
    private fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        SPUtil(url, cookies)
//        var spUrl: String by SPUtil(url, cookies)
//        spUrl = cookies
        domain ?: return
        SPUtil(domain, cookies)
//        var spDomain: String by SPUtil(domain, cookies)
//        spDomain = cookies
    }
}