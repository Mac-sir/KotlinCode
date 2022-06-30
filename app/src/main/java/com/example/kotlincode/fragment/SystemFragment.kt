package com.example.kotlincode.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.example.kotlincode.adpter.SystemAdapter
import com.example.kotlincode.databinding.FragmentNormalBinding
import com.example.kotlincode.http.bean.BaseDatas
import com.example.kotlincode.http.bean.TreeListData
import com.example.kotlincode.presenter.SystemPresenterImpl
import com.example.kotlincode.view.fragment.SystemView

class SystemFragment : Fragment(), SystemView,
    SwipeRefreshLayout.OnRefreshListener,OnItemClickListener {
    companion object {
        fun newInstance(): SystemFragment {
            return SystemFragment()
        }
    }

    lateinit var binding: FragmentNormalBinding

    private var treeListData = mutableListOf<TreeListData>()

    private val mPresenter: SystemPresenterImpl by lazy {
        SystemPresenterImpl(this)
    }

    private val mAdapter: SystemAdapter by lazy {
        SystemAdapter(treeListData)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNormalBinding.inflate(inflater, container, false)
        binding.run {
            tabSwipeRefresh.isRefreshing = true
            tabSwipeRefresh.setOnRefreshListener(this@SystemFragment)
            tabRecyclerView.adapter = mAdapter
        }
        mPresenter.getSystemList()
        return binding.root
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

    }

    override fun onRefresh() {
        mPresenter.getSystemList()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun getDataSuccess(data: List<TreeListData>) {
        binding.tabSwipeRefresh.isRefreshing = false
        treeListData.clear()
        treeListData.addAll(data)
        mAdapter.notifyDataSetChanged()
    }

    override fun getDataFailed(error: String) {
        binding.tabSwipeRefresh.isRefreshing = false
    }
}