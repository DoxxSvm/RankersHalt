package com.doxx.rankershalt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Adapter(var context :Context?, var items: ArrayList<Books>,private val listener : ItemClicked): RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        //xml to view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_books,parent,false)
        val viewHol = viewHolder(view)

        view.setOnClickListener{
            listener.onClick(items[viewHol.adapterPosition])
        }
        //then it will return that view to viewHolder
        return viewHol

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val current = items[position]
        holder.title.text=current.bookName

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class viewHolder (itemView: View ) :RecyclerView.ViewHolder(itemView){
    val title = itemView.findViewById<TextView>(R.id.title)
}
interface ItemClicked{
    fun onClick(item: Books)
}