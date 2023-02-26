package com.example.kotlinlearn

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kotlinlearn.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain2Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main2)
        val sahred: SharedPreferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val mm = sahred.getString("myname", null)
        if (!mm.isNullOrBlank()) {
            binding.textView.text = mm
        }

        val arr = arrayListOf("ok", "ok", "ok", "ok")
        binding.list.adapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arr)

        binding.button3.setOnClickListener {
            val ss = binding.editTextTextPersonName.text.toString()
            if (ss.isEmpty()) {
                binding.editTextTextPersonName.error = "Error"
                return@setOnClickListener
            }
            val s: SharedPreferences.Editor = sahred.edit()
            s.putString("myname", ss)
            s.apply()
        }

    }
}