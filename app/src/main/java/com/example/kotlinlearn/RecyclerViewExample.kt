package com.example.kotlinlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = layout
        var listj = arrayListOf<Model>(
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"),
            Model("mubb", "09090909"))
        val adapter = CAdapter(this, listj)
        rv.adapter = adapter

    }
}