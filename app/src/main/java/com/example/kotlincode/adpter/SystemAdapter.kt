package com.example.kotlincode.adpter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.kotlincode.R
import com.example.kotlincode.http.bean.TreeListData

class SystemAdapter(datas: MutableList<TreeListData>) :
    BaseQuickAdapter<TreeListData, BaseViewHolder>(R.layout.system_list_item, datas) {
    override fun convert(holder: BaseViewHolder, item: TreeListData) {
        holder.setText(R.id.systemItemFirst, item.name)
        item.children?.let { children ->
            holder.setText(
                R.id.systemItemSecond,
                children.joinToString("     ", transform = { child ->
                    child.name
                })
            )
        }

    }
}