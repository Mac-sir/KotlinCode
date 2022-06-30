package com.example.kotlincode.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlincode.fragment.NaviFragment
import com.example.kotlincode.fragment.SystemFragment

class FragmentSystemAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private var fragments = mutableListOf<Fragment>()

    init {
        fragments.add(SystemFragment.newInstance())
        fragments.add(NaviFragment.newInstance())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]

}