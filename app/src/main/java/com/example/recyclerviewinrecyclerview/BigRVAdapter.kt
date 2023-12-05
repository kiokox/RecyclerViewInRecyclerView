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
    LIST0(0),
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
        addItemType(ItemType.LIST0.num, R.layout.item_rv)
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

            // 因为后面的原因，不用这个方法了，表里数据里其实没有1类型的，1->该段代码没啥用，纯保存
            1 -> {
                holder.setText(R.id.tv_list, item.title)
                val smallRVAdapter = SmallRVAdapter(stringList)
                val linearLayoutManager = LinearLayoutManager(context)
                val smallRecyclerView = holder.getView<RecyclerView>(R.id.rv_list)
                smallRecyclerView.layoutManager = linearLayoutManager
                smallRecyclerView.adapter = smallRVAdapter

                smallRecyclerView.setOnTouchListener { view, motionEvent ->
                    when (motionEvent.action) {
                        //当用户按下的时候，告诉父组件，不熬拦截我的事件（这个时候子组件是可以正常响应事件的），拿起之后就会告诉父组件可以阻止。
                        //但是这个方法不能在子组件item拽到底的时候把父组件拽上来，手指还是得拽父组件的item，不够人性化
                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> view.parent.requestDisallowInterceptTouchEvent(
                            true
                        )

                        MotionEvent.ACTION_UP -> view.parent.requestDisallowInterceptTouchEvent(
                            false
                        )

                    }
                    false
                }
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