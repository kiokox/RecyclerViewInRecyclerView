package com.example.recyclerviewinrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewinrecyclerview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bigRVAdapter by lazy(LazyThreadSafetyMode.NONE) {
        BigRVAdapter(arrayList,this,binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBig.layoutManager = LinearLayoutManager(this)
        binding.rvBig.adapter = bigRVAdapter

    }

    private val arrayList: ArrayList<ItemEntity>
        get() = arrayListOf(
            ItemEntity("1号作者",stringList,0),
            ItemEntity("2号作者",stringList,2),
            ItemEntity("3号作者",stringList,0),
            ItemEntity("4号作者",stringList,2),
            ItemEntity("5号作者",stringList,0),
            ItemEntity("6号作者",stringList,2),
            ItemEntity("7号作者",stringList,0),

        )

    private val stringList: ArrayList<String>
        get() = arrayListOf(
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww"
        )
}


