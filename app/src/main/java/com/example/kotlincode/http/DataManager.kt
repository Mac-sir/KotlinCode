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
        RequestHelp.retrofitService.getList(page)
            .enqueue(object : Callback<BaseBean<BaseData>> {
                override fun onResponse(
                    call: Call<BaseBean<BaseData>>,
                    response: Response<BaseBean<BaseData>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<BaseData>>, t: Throwable) {

                }
            })
    }

    /**
     * 获取广场数据
     */
    fun getSquareList(page: Int, callback: BaseCallback<BaseData>) {
        RequestHelp.retrofitService.getSquareList(page)
            .enqueue(object : Callback<BaseBean<BaseData>> {
                override fun onResponse(
                    call: Call<BaseBean<BaseData>>,
                    response: Response<BaseBean<BaseData>>
                ) {
                    val result = response.body()?.data
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
            .enqueue(object : Callback<BaseBean<List<BannerData>>> {
                override fun onResponse(
                    call: Call<BaseBean<List<BannerData>>>,
                    response: Response<BaseBean<List<BannerData>>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<List<BannerData>>>, t: Throwable) {
                    t.message?.let { Log.i("TAG", it) }
                }

            })
    }

    /**
     * 体系数据
     */
    fun getTypeTreeList(callback: BaseListCallback<TreeListData>) {
        RequestHelp.retrofitService.getTypeTreeList()
            .enqueue(object : Callback<BaseBean<List<TreeListData>>> {
                override fun onResponse(
                    call: Call<BaseBean<List<TreeListData>>>,
                    response: Response<BaseBean<List<TreeListData>>>
                ) {
                    val result: List<TreeListData>? = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<List<TreeListData>>>, t: Throwable) {

                }

            })
    }

    fun getTreeChildrenList(id: Int, page: Int, callback: BaseCallback<BaseData>) {
        RequestHelp.retrofitService.getTreeChildrenList(page, id)
            .enqueue(object : Callback<BaseBean<BaseData>> {
                override fun onResponse(
                    call: Call<BaseBean<BaseData>>,
                    response: Response<BaseBean<BaseData>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<BaseData>>, t: Throwable) {

                }
            })
    }

    fun getNaviList(callback: BaseListCallback<NaviData>) {
        RequestHelp.retrofitService.getNaviList()
            .enqueue(object : Callback<BaseBean<List<NaviData>>> {
                override fun onResponse(
                    call: Call<BaseBean<List<NaviData>>>,
                    response: Response<BaseBean<List<NaviData>>>
                ) {
                    val result: List<NaviData>? = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<List<NaviData>>>, t: Throwable) {

                }
            })
    }

    /**
     * 获取公众号数据
     */
    fun getChaptersList(callback: BaseListCallback<TreeListData>) {
        RequestHelp.retrofitService.getChaptersList()
            .enqueue(object : Callback<BaseBean<List<TreeListData>>> {
                override fun onResponse(
                    call: Call<BaseBean<List<TreeListData>>>,
                    response: Response<BaseBean<List<TreeListData>>>
                ) {
                    val result: List<TreeListData>? = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<List<TreeListData>>>, t: Throwable) {

                }

            })
    }

    /**
     * 获取公众号下的文章
     */
    fun getChaptersContentList(id: Int, page: Int, callback: BaseCallback<BaseData>) {
        RequestHelp.retrofitService.getChaptersContentList(id, page)
            .enqueue(object : Callback<BaseBean<BaseData>> {
                override fun onResponse(
                    call: Call<BaseBean<BaseData>>,
                    response: Response<BaseBean<BaseData>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<BaseData>>, t: Throwable) {

                }
            })
    }

    /**
     * 获取项目数据
     */
    fun getProjectList(callback: BaseListCallback<TreeListData>) {
        RequestHelp.retrofitService.getProjectList()
            .enqueue(object : Callback<BaseBean<List<TreeListData>>> {
                override fun onResponse(
                    call: Call<BaseBean<List<TreeListData>>>,
                    response: Response<BaseBean<List<TreeListData>>>
                ) {
                    val result: List<TreeListData>? = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<List<TreeListData>>>, t: Throwable) {

                }

            })
    }

    /**
     * 获取项目下的文章
     */
    fun getProjectContentList(id: Int, page: Int, callback: BaseCallback<BaseData>) {
        RequestHelp.retrofitService.getProjectContentList(page, id)
            .enqueue(object : Callback<BaseBean<BaseData>> {
                override fun onResponse(
                    call: Call<BaseBean<BaseData>>,
                    response: Response<BaseBean<BaseData>>
                ) {
                    val result = response.body()?.data
                    if (response.isSuccessful && result != null) {
                        callback.success(result)
                    }
                }

                override fun onFailure(call: Call<BaseBean<BaseData>>, t: Throwable) {

                }
            })
    }

    /**
     * "rv安",
     * "rv123456"
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

                }
            }

            override fun onFailure(call: Call<BaseBean<LoginData>>, t: Throwable) {
                t.message?.let { Log.i("tag", it) }
            }
        })
    }

}