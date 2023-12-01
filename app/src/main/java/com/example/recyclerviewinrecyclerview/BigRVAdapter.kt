package com.example.recyclerviewinrecyclerview

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.recyclerviewinrecyclerview.R

/**
 * @Author : Quzx
 * @Time : 2023/12/1 15:43
 */
class BigRVAdapter(private var arrayList: ArrayList<String>): BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_view,arrayList) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(
            R.id.tv_item,
            item
        )
    }
}