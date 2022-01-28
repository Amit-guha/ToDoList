package com.example.todosample.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todosample.R
import com.example.todosample.data.model.ItemName

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var userlist = emptyList<ItemName>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.databaseshow, parent, false)
        return ItemViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentitem = userlist[position]
        holder.apply {
            taskname.text = currentitem.namesItem

            buttn.setOnClickListener {
                buttn.setBackgroundResource(R.drawable.check)
               // taskname.setTextColor(R.color.gray)
                taskname.setPaintFlags(taskname.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            }
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class ItemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val taskname: TextView = itemview.findViewById(R.id.tv_task)
        val buttn : ImageButton =itemview.findViewById(R.id.lay)
    }

    fun setData(user: List<ItemName>) {
        this.userlist = user
        notifyDataSetChanged()
    }
}