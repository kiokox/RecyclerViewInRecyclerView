package com.example.recyclerviewinrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewinrecyclerview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bigRVAdapter by lazy(LazyThreadSafetyMode.NONE) {
        BigRVAdapter(arrayList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBig.layoutManager = LinearLayoutManager(this)
        binding.rvBig.adapter = bigRVAdapter

    }

    private val arrayList: ArrayList<String>
        get() = arrayListOf(
            "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww", "1wwwww"

        )
}


