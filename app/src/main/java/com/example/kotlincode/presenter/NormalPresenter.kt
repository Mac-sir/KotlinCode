package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.TreeListData

interface NormalPresenter {

    interface OnChaptersListener {
        fun getChaptersList()
    }

    interface OnProjectListener {
        fun getProjectList()
    }

    interface OnPublicListener{
        fun getDataSuccess(chapters: List<TreeListData>)

        fun getDataFailed(error: String)
    }
}