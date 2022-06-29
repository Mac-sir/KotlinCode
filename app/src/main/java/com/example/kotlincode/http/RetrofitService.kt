package com.example.kotlincode.http

import com.example.kotlincode.http.bean.*
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */

    @GET("/article/list/{page}/json")
    fun getList(
        @Path("page") page: Int
    ): Call<BaseBean<BaseData>>

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    fun getTypeTreeList(): Call<BaseBean<TreeListData>>

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0/json?cid=168
     * @param page page
     * @param cid cid
     */
    @GET("/article/list/{page}/json")
    fun getArticleList(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): Call<BaseBean<ArticleListData>>

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     */
    @GET("/friend/json")
    fun getFriendList(): Call<BaseBean<FriendListData>>

    /**
     * 大家都在搜
     * http://www.wanandroid.com/hotkey/json
     */
    @GET("/hotkey/json")
    fun getHotKeyList(): Call<BaseBean<HotKeyData>>

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page page
     * @param k POST search key
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    fun getSearchList(
        @Path("page") page: Int,
        @Field("k") k: String
    ): Call<BaseBean<HomeListData>>

    /**
     * 登录
     * @param username username
     * @param password password
     * @return BaseBean<LoginData>
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginWan(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<BaseBean<LoginData>>

    /**
     * 注册
     * @param username username
     * @param password password
     * @param repassword repassword
     * @return BaseBean<LoginData>
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerWanAndroid(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassowrd: String
    ): Call<BaseBean<LoginData>>

    /**
     * 获取自己收藏的文章列表
     * @param page page
     * @return BaseBean<HomeListData>
     */
    @GET("/lg/collect/list/{page}/json")
    fun getLikeList(
        @Path("page") page: Int
    ): Call<BaseBean<HomeListData>>

    /**
     * 收藏文章
     * @param id id
     * @return BaseBean<HomeListData>
     */
    @POST("/lg/collect/{id}/json")
    fun addCollectArticle(
        @Path("id") id: Int
    ): Call<BaseBean<HomeListData>>

    /**
     * 收藏站外文章
     * @param title title
     * @param author author
     * @param link link
     * @return BaseBean<HomeListData>
     */
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    fun addCollectOutsideArticle(
        @Field("title") title: String,
        @Field("author") author: String,
        @Field("link") link: String
    ): Call<BaseBean<HomeListData>>

    /**
     * 删除收藏文章
     * @param id id
     * @param originId -1
     * @return BaseBean<HomeListData>
     */
    @POST("/lg/uncollect/{id}/json")
    @FormUrlEncoded
    fun removeCollectArticle(
        @Path("id") id: Int,
        @Field("originId") originId: Int = -1
    ): Call<BaseBean<HomeListData>>

    /**
     * 首页Banner
     * @return BaseBean<BannerData>
     */
    @GET("/banner/json")
    fun getBanner(): Call<BaseBean<List<BannerData>>>

    /**
     * 我的常用网址
     * @return BaseBean<FriendListData>
     */
    @GET("/lg/collect/usertools/json")
    fun getBookmarkList(): Call<BaseBean<FriendListData>>
}