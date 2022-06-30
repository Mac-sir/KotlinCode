package com.example.kotlincode.adpter

import android.content.Context
import com.bumptech.glide.Glide
import com.example.kotlincode.http.bean.BannerData
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

class ImageAdapter(private val context: Context, data: MutableList<BannerData>) :
    BannerImageAdapter<BannerData>(data) {
    override fun onBindView(
        holder: BannerImageHolder?,
        data: BannerData?,
        position: Int,
        size: Int
    ) {
        holder ?: return
        Glide.with(context).load(data?.imagePath).into(holder.imageView)
    }
}