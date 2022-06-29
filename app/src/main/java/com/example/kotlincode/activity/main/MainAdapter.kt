package com.example.kotlincode.activity.main

import android.content.Context
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.kotlincode.R
import com.example.kotlincode.http.bean.BaseDatas

class MainAdapter(context: Context, datas: MutableList<BaseDatas>) :
    BaseQuickAdapter<BaseDatas, BaseViewHolder>(R.layout.main_list_item, datas), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: BaseDatas) {
        item ?: return
        holder.apply {
            setText(R.id.mainTitleTv, item.title)
            setText(R.id.mainDateTv, item.niceDate)
            setText(R.id.mainAuthorTv, item.author)
            setText(R.id.mainTypeTv, item.chapterName)
            setImageResource(
                R.id.mainLikeImg,
                if (item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
            setTextColor(R.id.mainTypeTv, context.resources.getColor(R.color.purple_500))
        }

    }
}