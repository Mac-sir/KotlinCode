package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.*

interface MainPresenter {
    interface OnMainListListener {
        fun getList(page: Int = 0)

        fun getListSuccess(data: BaseData)

        fun getListFailed(error: String)
    }



    interface OnFriendListener {
        fun getFriendList()

        fun getFriendListSuccess(friendListData: FriendListData)

        fun getFriendListFailed()
    }

    interface OnCollectArticleListener{
        fun collectArticle(id:Int,isAdd:Boolean)

        fun collectArticleSuccess(result: BaseData, isAdd: Boolean)

        fun collectArticleFailed(errorMessage: String?, isAdd: Boolean)
    }

    interface OnBannerListener {
        fun getBanner()

        fun getBannerSuccess(bannerData: List<BannerData>)

        fun getBannerFailed(error: String)
    }
}