package com.example.recyclerviewinrecyclerview

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.recyclerviewinrecyclerview.R

/**
 * @Author : Quzx
 * @Time : 2023/12/4 9:42
 */
class SmallRVAdapter(private val arrayList: ArrayList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_tv, arrayList) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_text, item)
    }
}