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
     * 广场数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */
    @GET("/user_article/list/{page}/json")
    fun getSquareList(
        @Path("page") page: Int
    ): Call<BaseBean<BaseData>>


    /**
     *
     * 公众号
     * https://wanandroid.com/wxarticle/chapters/json
     */
    @GET("/wxarticle//chapters/json")
    fun getChaptersList(): Call<BaseBean<List<TreeListData>>>

    /**
     *
     * 公众号
     * https://wanandroid.com/wxarticle/list/408/1/json
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    fun getChaptersContentList(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): Call<BaseBean<BaseData>>

    /**
     *
     * 项目
     * https://www.wanandroid.com/project/tree/json
     */
    @GET("/project/tree/json")
    fun getProjectList(): Call<BaseBean<List<TreeListData>>>

    /**
     * 项目的文章
     * https://www.wanandroid.com/project/list/1/json?cid=294
     * @param page page
     * @param cid cid
     */
    @GET("/project/list/{page}/json")
    fun getProjectContentList(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): Call<BaseBean<BaseData>>


    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    fun getTypeTreeList(): Call<BaseBean<List<TreeListData>>>

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
    ): Call<BaseBean<BaseData>>


    /**
     * 导航
     * https://www.wanandroid.com/navi/json
     * */
    fun getNaviList(): Call<BaseBean<List<NaviData>>>



    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     */
    @GET("/friend/json")
    fun getFriendList(): Call<BaseBean<List<FriendListData>>>

    /**
     * 大家都在搜
     * http://www.wanandroid.com/hotkey/json
     */
    @GET("/hotkey/json")
    fun getHotKeyList(): Call<BaseBean<List<HotKeyData>>>

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
    ): Call<BaseBean<BaseData>>

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
     * @return BaseBean<BaseData>
     */
    @GET("/lg/collect/list/{page}/json")
    fun getLikeList(
        @Path("page") page: Int
    ): Call<BaseBean<BaseData>>

    /**
     * 收藏文章
     * @param id id
     * @return BaseBean<HomeListData>
     */
    @POST("/lg/collect/{id}/json")
    fun addCollectArticle(
        @Path("id") id: Int
    ): Call<BaseBean<BaseData>>

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
    ): Call<BaseBean<BaseData>>

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
    ): Call<BaseBean<BaseData>>

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
    fun getBookmarkList(): Call<BaseBean<List<FriendListData>>>
}