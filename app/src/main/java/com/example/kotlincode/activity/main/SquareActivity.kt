package com.example.kotlincode.activity.main

import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.example.kotlincode.R
import com.example.kotlincode.activity.BaseActivity
import com.example.kotlincode.adpter.CommonAdapter
import com.example.kotlincode.databinding.ActivitySquareBinding
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.bean.BaseDatas
import com.example.kotlincode.presenter.SquarePresenterImpl
import com.example.kotlincode.startPreview
import com.example.kotlincode.view.SquareView

class SquareActivity : BaseActivity(), SquareView, SwipeRefreshLayout.OnRefreshListener,
    OnLoadMoreListener, OnItemClickListener {

    override fun getBinding(): ViewBinding = ActivitySquareBinding.inflate(layoutInflater)

    private lateinit var binding: ActivitySquareBinding

    private var data = mutableListOf<BaseDatas>()

    private val commonAdapter: CommonAdapter by lazy {
        CommonAdapter(this, data)
    }

    private val squarePresenter: SquarePresenterImpl by lazy {
        SquarePresenterImpl(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding = mBinding as ActivitySquareBinding
        binding.run {
            swipeRefresh.isRefreshing = true
            swipeRefresh.setOnRefreshListener(this@SquareActivity)
            recycleView.adapter = commonAdapter
            toolbar.title = getString(R.string.square_name)
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
        commonAdapter.run {
            loadMoreModule.setOnLoadMoreListener(this@SquareActivity)
            setOnItemClickListener(this@SquareActivity)
        }
        squarePresenter.getSquareList()
    }

    override fun onLoadMore() {
        val page = commonAdapter.data.size / 20 + 1
        squarePresenter.getSquareList(page)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        startPreview(this@SquareActivity, commonAdapter.data[position].link)
    }

    override fun getListSuccess(data: BaseData) {
        data.datas?.let {
            val all = data.total
            val isRefresh = binding.swipeRefresh.isRefreshing
            commonAdapter.run {
                if (data.offset >= all || data.size >= all) {
                    return
                }
                if (isRefresh) {
                    setList(it)
                } else {
                    addData(it)
                }
                loadMoreModule.loadMoreComplete()
                loadMoreModule.isEnableLoadMore = true
            }
        }
        binding.swipeRefresh.isRefreshing = false
    }

    override fun getListFailed(error: String) {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun onRefresh() {
        binding.swipeRefresh.isRefreshing = true
        squarePresenter.getSquareList()
    }
}