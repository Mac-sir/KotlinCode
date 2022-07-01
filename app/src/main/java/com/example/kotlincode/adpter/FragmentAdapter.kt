package com.example.kotlincode.adpter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlincode.fragment.NormalFragment
import com.example.kotlincode.http.bean.TreeListData

class FragmentAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private var fragments = mutableListOf<Fragment>()

    var title = ""

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<TreeListData>) {
        if (fragments.size != list.size) {
            fragments.clear()
            if (!list.isNullOrEmpty()) {
                list.forEach {
                    fragments.add(NormalFragment.newInstance(it.id, title))
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]

}