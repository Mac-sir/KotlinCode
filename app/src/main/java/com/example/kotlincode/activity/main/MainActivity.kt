package com.example.kotlincode.activity.main

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.example.kotlincode.R
import com.example.kotlincode.activity.BaseActivity
import com.example.kotlincode.activity.PreviewActivity
import com.example.kotlincode.databinding.ActivityMainBinding
import com.example.kotlincode.http.bean.BannerData
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.bean.BaseDatas
import com.example.kotlincode.presenter.MainPresenterImpl
import com.example.kotlincode.view.MainView
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator

class MainActivity : BaseActivity(), MainView, OnLoadMoreListener {
    companion object {
        const val tag = "MainActivity"
    }

    private val mainPresenter: MainPresenterImpl by lazy {
        MainPresenterImpl(this)
    }

    private val mData = mutableListOf<BaseDatas>()

    private var mBannerData = mutableListOf<BannerData>()

    private val mainAdapter: MainAdapter by lazy {
        MainAdapter(this, mData)
    }

    private val bannerAdapter: ImageAdapter by lazy {
        ImageAdapter(this, mBannerData)
    }

    private lateinit var mainHead: LinearLayout

    private lateinit var mainBanner: Banner<BannerData, ImageAdapter>

    private lateinit var binding: ActivityMainBinding

    override fun getBinding(): ViewBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        Log.i(tag, "onCreate")
        binding = (mBinding as ActivityMainBinding)
        binding.swipeRefresh.run {
            isRefreshing = true
            setOnRefreshListener(onRefreshListener)
        }
        mainHead = this.layoutInflater.inflate(R.layout.main_head_item, null) as LinearLayout
        mainBanner = mainHead.findViewById(R.id.mainBanner)
        binding.recycleView.run {
            adapter = mainAdapter
        }
        mainAdapter.run {
            addHeaderView(mainHead)
            loadMoreModule.setOnLoadMoreListener(this@MainActivity)
            setOnItemClickListener(onItemClickListener)
        }
        mainBanner.run {
            setAdapter(bannerAdapter)
            setIndicator(CircleIndicator(this@MainActivity))
        }
        mainPresenter.getBanner()
        mainPresenter.getList()
    }

    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        binding.swipeRefresh.isRefreshing = true
        mainPresenter.getBanner()
        mainPresenter.getList()
    }

    private val onItemClickListener = OnItemClickListener { adapter, view, position ->
        //BaseQuickAdapter3.0.7 OnItemClickListener 点击闪退
        val intent = Intent(this@MainActivity, PreviewActivity::class.java)
        intent.data = Uri.parse(mainAdapter.data[position].link)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart")
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun getBannerSuccess(data: List<BannerData>) {
        binding.swipeRefresh.isRefreshing = false
        mBannerData.clear()
        mBannerData.addAll(data)
        bannerAdapter.notifyDataSetChanged()
    }

    override fun getBannerFailed(error: String) {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun getMainSuccess(data: BaseData) {
        data.datas?.let {
            val all = data.total
            val isRefresh = binding.swipeRefresh.isRefreshing
            mainAdapter.run {
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

    override fun getMainFailed(error: String) {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun onLoadMore() {
        val page = mainAdapter.data.size / 20 + 1
        mainPresenter.getList(page)
    }
}
