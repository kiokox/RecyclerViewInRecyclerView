package com.example.recyclerviewinrecyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.MotionEvent
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
    LIST(0),
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

    @SuppressLint("ClickableViewAccessibility")
    override fun convert(holder: BaseViewHolder, item: ItemEntity) {
        when (holder.itemViewType) {
            0 -> {
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
            "1wwwww", "2wwwww", "3wwwww", "4wwwww", "5wwwww", "6wwwww", "7wwwww",
            "8wwwww", "9wwwww", "10wwwww", "11wwwww", "12wwwww", "13wwwww", "14wwwww",
        )

}