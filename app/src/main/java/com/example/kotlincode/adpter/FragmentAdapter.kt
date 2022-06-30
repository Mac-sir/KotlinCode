package com.example.kotlincode.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlincode.fragment.NormalFragment
import com.example.kotlincode.http.bean.TreeListData

class FragmentAdapter(activity: FragmentActivity, val list: MutableList<TreeListData.Children>) :
    FragmentStateAdapter(activity) {

    private var fragments = mutableListOf<Fragment>()

    var title = ""

    override fun getItemCount(): Int {
        if (fragments.size != list.size) {
            list.forEach {
                fragments.add(NormalFragment.newInstance(it.id, title))
            }
        }
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]

}