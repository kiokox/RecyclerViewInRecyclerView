package com.example.recyclerviewinrecyclerview

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.recyclerviewinrecyclerview.databinding.ActivityMainBinding
import com.example.recyclerviewinrecyclerview.databinding.ItemRvBinding
import kotlinx.coroutines.withContext

/**
 * @Author : Quzx
 * @Time : 2023/12/1 15:43
 */
enum class ItemType(var num: Int) {
    LIST(1),
    TEXT(2)
}

class BigRVAdapter(
    arrayList: ArrayList<ItemEntity>,
    context: Context,
    binding: ActivityMainBinding
) :
    BaseMultiItemQuickAdapter<ItemEntity, BaseViewHolder>(arrayList) {
    init {
        addItemType(ItemType.LIST.num, R.layout.item_rv)
        addItemType(ItemType.TEXT.num, R.layout.item_tv)
    }

    override fun convert(holder: BaseViewHolder, item: ItemEntity) {
        when (holder.itemViewType) {
            1 -> {
                holder.setText(R.id.tv_list, item.title)
                val smallRVAdapter = SmallRVAdapter(stringList)
                val linearLayoutManager = LinearLayoutManager(context)
                val smallRecyclerView = holder.getView<RecyclerView>(R.id.rv_list)
                smallRecyclerView.layoutManager = linearLayoutManager
                smallRecyclerView.adapter = smallRVAdapter
            }

            2 -> {
                holder.setText(R.id.tv_text, item.title)
            }
        }
    }

    private val stringList: ArrayList<String>
        get() = arrayListOf(
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww",
        )

}