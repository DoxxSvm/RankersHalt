package com.doxx.rankershalt

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.fragment_jee_materials.*
import kotlinx.android.synthetic.main.fragment_neet_materials.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Adapter(var context :Context?, var items: ArrayList<Books>,private val listener : ItemClicked): RecyclerView.Adapter<viewHolder>() {
    val adRequest = AdRequest.Builder().build()
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