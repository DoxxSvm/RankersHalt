package com.doxx.rankershalt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DownloadsAdapter(var items: ArrayList<String>,private val listener : ItemClickedDownloads): RecyclerView.Adapter<ViewHolderDownloads>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDownloads {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_downloads,parent,false)
        val viewHol = ViewHolderDownloads(view)

        view.setOnClickListener{
            listener.onClick(items.get(viewHol.adapterPosition))
        }
        return viewHol

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderDownloads, position: Int) {
        val current = items[position]
        current.also { holder.title.text = it }
    }


}
class ViewHolderDownloads (itemView: View) : RecyclerView.ViewHolder(itemView){
    val title = itemView.findViewById<TextView>(R.id.DownloadedBook)
}
interface ItemClickedDownloads{
    fun onClick(item: String)
}