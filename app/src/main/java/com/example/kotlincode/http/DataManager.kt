package com.example.kotlincode.http

import android.util.Log
import com.example.kotlincode.http.bean.*
import com.example.kotlincode.http.callback.BaseCallback
import com.example.kotlincode.http.callback.BaseListCallback
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object DataManager {


    /**
     * 获取主页数据
     */
    fun getList(page: Int, callback: BaseCallback<BaseData>) {
        val call = RequestHelp.retrofitService.getList(page)
        call.enqueue(object : Callback<BaseBean<BaseData>> {
            override fun onResponse(
                call: Call<BaseBean<BaseData>>,
                response: Response<BaseBean<BaseData>>
            ) {
                val result= response.body()?.data
                if (response.isSuccessful && result != null) {
                    callback.success(result)
                }
            }

            override fun onFailure(call: Call<BaseBean<BaseData>>, t: Throwable) {

            }
        })
    }

    /**
     *  获取轮播图数据
     *  */
    fun getBanner(callback: BaseListCallback<BannerData>) {
        RequestHelp.retrofitService.getBanner()
            .enqueue(object : Callback<BaseBean<List<BannerData>>>{
                override fun onResponse(
                    call: Call<BaseBean<List<BannerData>>>,
                    response: Response<BaseBean<List<BannerData>>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                    Log.i("TAG",""+response.isSuccessful)
                }

                override fun onFailure(call: Call<BaseBean<List<BannerData>>>, t: Throwable) {
                    t.message?.let { Log.i("TAG", it) }
                }

            })
    }

    fun getTypeTreeList(callback: BaseCallback<TreeListData>) {
        RequestHelp.retrofitService.getTypeTreeList()
            .enqueue(object : Callback<BaseBean<TreeListData>> {
                override fun onResponse(
                    call: Call<BaseBean<TreeListData>>,
                    response: Response<BaseBean<TreeListData>>
                ) {
                    val result: TreeListData? = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<TreeListData>>, t: Throwable) {

                }

            })
    }


    /**
     * "rv安卓", "rv123456"
     * 登录WanAndroid
     */
    fun loginWan(username: String, userPassword: String, callback: BaseCallback<LoginData>) {
        val call = RequestHelp.retrofitService.loginWan(username, userPassword)
        call.enqueue(object : Callback<BaseBean<LoginData>> {
            override fun onResponse(
                call: Call<BaseBean<LoginData>>,
                response: Response<BaseBean<LoginData>>
            ) {
                val results: BaseBean<LoginData>? = response.body()
                if (response.isSuccessful && results != null) {
                    val Gs = Gson()

                    Log.i("TAG", "" + Gs.toJson(results.data))
                    //callback.success(results.data)
                }
            }

            override fun onFailure(call: Call<BaseBean<LoginData>>, t: Throwable) {
                t.message?.let { Log.i("tag", it) }
            }
        })
    }

}