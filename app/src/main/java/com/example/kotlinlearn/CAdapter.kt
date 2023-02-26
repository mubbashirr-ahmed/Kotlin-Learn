package com.example.kotlinlearn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CAdapter(var context: Context, var arrayList: ArrayList<Model> ) : RecyclerView.Adapter<CAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.namee.text = arrayList[position].name
        holder.enroll.text = arrayList[position].age
    }
    inner class VH(item: View):RecyclerView.ViewHolder(item){
        var namee = item.findViewById<TextView>(R.id.name)
        var enroll = item.findViewById<TextView>(R.id.enroll)
    }
}