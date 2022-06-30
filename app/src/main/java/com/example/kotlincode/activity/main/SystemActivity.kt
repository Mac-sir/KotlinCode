package com.example.kotlincode.activity.main

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.kotlincode.activity.BaseActivity
import com.example.kotlincode.adpter.FragmentAdapter
import com.example.kotlincode.adpter.FragmentSystemAdapter
import com.example.kotlincode.databinding.ActivityNormalBinding
import com.example.kotlincode.databinding.ActivitySystemBinding
import com.google.android.material.tabs.TabLayoutMediator

class SystemActivity : BaseActivity() {
    override fun getBinding(): ViewBinding = ActivitySystemBinding.inflate(layoutInflater)

    private val titles = listOf("体系", "导航")

    private val systemAdapter: FragmentSystemAdapter by lazy {
        FragmentSystemAdapter(this)
    }

    private lateinit var binding: ActivitySystemBinding

    override fun initView(savedInstanceState: Bundle?) {
        binding = mBinding as ActivitySystemBinding
        binding.run {
            systemViewPager.adapter = systemAdapter
            systemToolbar.setNavigationOnClickListener {
                onBackPressed()
            }
            TabLayoutMediator(systemTabs, systemViewPager) { tab, position ->
                tab.text = titles[position]
            }.attach()
        }
    }
}