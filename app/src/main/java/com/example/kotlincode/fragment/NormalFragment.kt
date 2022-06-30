package com.example.kotlincode.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.example.kotlincode.Constant
import com.example.kotlincode.R
import com.example.kotlincode.adpter.CommonAdapter
import com.example.kotlincode.databinding.FragmentNormalBinding
import com.example.kotlincode.http.bean.BaseData
import com.example.kotlincode.http.bean.BaseDatas
import com.example.kotlincode.presenter.FragmentPresenterImpl
import com.example.kotlincode.startPreview
import com.example.kotlincode.view.fragment.NormalView

class NormalFragment : Fragment(), NormalView,
    SwipeRefreshLayout.OnRefreshListener,
    OnLoadMoreListener, OnItemClickListener {
    companion object {
        fun newInstance(id: Int, subtitle: String): NormalFragment {
            val fragment = NormalFragment()
            val args = Bundle()
            args.putInt(Constant.COMMON_ID_KEY, id)
            args.putString(Constant.COMMON_SUBTITLE_KEY, subtitle)
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentNormalBinding

    var cid: Int = 0
    lateinit var title: String

    private var data = mutableListOf<BaseDatas>()

    private val mAdapter: CommonAdapter by lazy {
        CommonAdapter(requireActivity(), data)
    }

    private val mPresenter: FragmentPresenterImpl by lazy {
        FragmentPresenterImpl(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNormalBinding.inflate(inflater, container, false)
        binding.run {
            tabRecyclerView.adapter = mAdapter
            tabSwipeRefresh.setOnRefreshListener(this@NormalFragment)
        }
        mAdapter.run {
            loadMoreModule.setOnLoadMoreListener(this@NormalFragment)
            setOnItemClickListener(this@NormalFragment)
        }
        selectMethod()
        return binding.root
    }

    private fun selectMethod() {
        arguments?.getInt(Constant.COMMON_ID_KEY, 0)?.let {
            cid = it
        }
        arguments?.getString(Constant.COMMON_SUBTITLE_KEY)?.let {
            title = it
        }
        binding.tabSwipeRefresh.isRefreshing = true
        when (title) {
            getString(R.string.official_name) -> mPresenter.getChapterContent(id = cid)
            getString(R.string.project_name) -> mPresenter.getProjectContent(id = cid)
        }
    }

    override fun getDataSuccess(data: BaseData) {
        Log.i("TAG","数据"+data.size)
        data.datas?.let {
            val all = data.total
            val isRefresh = binding.tabSwipeRefresh.isRefreshing
            mAdapter.run {
                Log.i("TAG","1进数据"+data.size)
                Log.i("TAG","2进数据"+data.offset)
                Log.i("TAG","3进数据"+data.total)
                Log.i("TAG","4进数据"+data.curPage)
                if (data.offset >= all || data.size >= all) {
                    return
                }
                if (isRefresh) {
                    Log.i("TAG","进数据"+data.size)
                    setList(it)
                } else {
                    addData(it)
                }
                loadMoreModule.loadMoreComplete()
                loadMoreModule.isEnableLoadMore = true
            }
        }
        binding.tabSwipeRefresh.isRefreshing = false
    }

    override fun getDataFailed(error: String) {
        binding.tabSwipeRefresh.isRefreshing = false
    }

    override fun onLoadMore() {
        val page = mAdapter.data.size / 20 + 1
        mPresenter.getChapterContent(cid, page)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        startPreview(requireActivity(), mAdapter.data[position].link)
    }

    override fun onRefresh() {
        binding.tabSwipeRefresh.isRefreshing = true
        when (title) {
            getString(R.string.official_name) -> mPresenter.getChapterContent(cid)
            getString(R.string.project_name) -> mPresenter.getProjectContent(cid)
        }
    }
}