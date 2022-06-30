package com.example.kotlincode.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.example.kotlincode.databinding.FragmentNormalBinding
import com.example.kotlincode.http.bean.BaseDatas

class NaviFragment : Fragment(),
    SwipeRefreshLayout.OnRefreshListener,
    OnLoadMoreListener, OnItemClickListener {
    companion object {
        fun newInstance(): NaviFragment {
            return NaviFragment()
        }
    }

    lateinit var binding: FragmentNormalBinding

    private var data = mutableListOf<BaseDatas>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNormalBinding.inflate(inflater, container, false)
        binding.run {
            tabSwipeRefresh.setOnRefreshListener(this@NaviFragment)
        }
        return binding.root
    }

    override fun onLoadMore() {

    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

    }

    override fun onRefresh() {

    }
}