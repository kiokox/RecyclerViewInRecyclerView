package com.example.recyclerviewinrecyclerview

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @Author : Quzx
 * @Time : 2023/12/4 9:05
 */
class ItemEntity (
    val title: String,
    val list: ArrayList<String>,
    override val itemType: Int
):MultiItemEntity
