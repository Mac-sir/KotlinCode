package com.example.kotlincode.presenter

import com.example.kotlincode.http.bean.BaseData

interface FragmentPresenter {
    interface OnChaptersContentListener {
        fun getChapterContent(id: Int, page: Int = 0)
        fun getChapterContentSuccess(data: BaseData)
        fun getChapterContentFailed(error: String)
    }

    interface OnProjectContentListener {
        fun getProjectContent(id: Int, page: Int = 0)
        fun getProjectContentSuccess(data: BaseData)
        fun getProjectContentFailed(error: String)
    }

    interface OnTreeChildrenListener {
        fun getTreeChildren(id: Int, page: Int = 0)
        fun getTreeChildrenSuccess(data: BaseData)
        fun getTreeChildrenFailed(error: String)
    }
}