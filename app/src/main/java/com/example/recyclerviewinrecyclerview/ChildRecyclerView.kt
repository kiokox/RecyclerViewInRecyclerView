package com.example.recyclerviewinrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView


/**
 * @Author : Quzx
 * @Time : 2023/12/4 15:04
 */
class ChildRecyclerView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        var isSliding: Boolean = false

        when (ev.action) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_MOVE-> {
                this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        isSliding = dy > 0
                    }

                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        //滑到顶了  滑到底了
                        if (!recyclerView.canScrollVertically(-1) || !recyclerView.canScrollVertically(
                                1
                            )
                        ) {
                            Toast.makeText( context,"拉动大RecyclerView", Toast.LENGTH_SHORT).show()
                            this@ChildRecyclerView.parent.requestDisallowInterceptTouchEvent(false)
                        }
                        else
                            this@ChildRecyclerView.parent.requestDisallowInterceptTouchEvent(true)
                    }
                })

                this.parent.requestDisallowInterceptTouchEvent(
                    true
                )
            }

            MotionEvent.ACTION_DOWN -> this.parent.requestDisallowInterceptTouchEvent(false)
        }
        return super.dispatchTouchEvent(ev)
    }

}