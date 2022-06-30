package com.example.kotlincode.activity.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.kotlincode.Constant
import com.example.kotlincode.R
import com.example.kotlincode.adpter.FragmentAdapter
import com.example.kotlincode.databinding.ActivityNormalBinding
import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.presenter.NormalPresenterImpl
import com.example.kotlincode.view.NormalView
import com.google.android.material.tabs.TabLayoutMediator

class NormalActivity : FragmentActivity(), NormalView {

    private var datas = mutableListOf<TreeListData.Children>()
    private var names = mutableListOf<TreeListData>()

    private lateinit var binding: ActivityNormalBinding

    private val normalPresenter: NormalPresenterImpl by lazy {
        NormalPresenterImpl(this)
    }

    private val normalAdapter: FragmentAdapter by lazy {
        FragmentAdapter(this, datas)
    }

    private var mTitle: String = ""
    private lateinit var tabLayout: TabLayoutMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras?.let {
            mTitle = it.getString(Constant.COMMON_TITLE_KEY, "未知").toString()
        }
        binding.run {
            normalToolbar.title = mTitle
            normalViewPager.adapter = normalAdapter
            normalToolbar.setNavigationOnClickListener {
                onBackPressed()
            }
            tabLayout = TabLayoutMediator(normalTabs, normalViewPager) { tab, position ->
                tab.text = names[position].name
            }
            tabLayout.attach()
            normalAdapter.title = mTitle
        }
        intent.extras?.let {
            when (mTitle) {
                getString(R.string.official_name) -> normalPresenter.getChaptersList()
                getString(R.string.project_name) -> normalPresenter.getProjectList()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun getDataSuccess(data: List<TreeListData>) {
        names.clear()
        names.addAll(data)
        names.forEach {
            normalAdapter.list.add(
                TreeListData.Children(
                    it.id, it.name, 0,
                    0, 0, 0, null
                )
            )
        }
        normalAdapter.notifyDataSetChanged()
    }

    override fun getDataFailed(error: String) {

    }
}