package com.example.kotlincode.adpter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.kotlincode.R
import com.example.kotlincode.http.bean.BaseDatas

class CommonAdapter(context: Context, datas: MutableList<BaseDatas>) :
    BaseQuickAdapter<BaseDatas, BaseViewHolder>(R.layout.common_list_item, datas), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: BaseDatas) {
        item ?: return
        holder.apply {
            setText(R.id.mainTitleTv, item.title)
            setText(R.id.mainDateTv, item.niceDate)
            setText(R.id.mainAuthorTv, if (item.author.isNotEmpty()) item.author else item.shareUser)
            setText(R.id.mainTypeTv, item.superChapterName + "/" + item.chapterName)
            setImageResource(
                R.id.mainLikeImg,
                if (item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
            setTextColor(R.id.mainTypeTv, context.resources.getColor(R.color.purple_500))
            setIsRecyclable(false)
        }
    }
}