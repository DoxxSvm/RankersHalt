package com.doxx.rankershalt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdView

class TestAdapter(var context :Context?, var items: ArrayList<Any>,private val listener : ItemClicked2): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        //xml to view
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_books,parent,false)
//        val viewHol = ItemViewHolder(view)
//
//        view.setOnClickListener{
//            listener.onClick(items[viewHol.adapterPosition])
//        }
//        //then it will return that view to viewHolder
//        return viewHol
//
//    }
override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
        MENU_ITEM_VIEW_TYPE -> {
            val menuItemLayoutView: View = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.item_books, viewGroup, false
            )
            val viewHol=ItemViewHolder(
                menuItemLayoutView
            )
            menuItemLayoutView.setOnClickListener{
            listener.onClick(items[viewHol.adapterPosition])
        }

            viewHol
        }
        BANNER_AD_VIEW_TYPE -> {
            val bannerLayoutView: View = LayoutInflater.from(
                viewGroup.context
            ).inflate(
                R.layout.banner_ad_container,
                viewGroup, false
            )
            AdViewHolder(bannerLayoutView)
        }
        else -> {
            val bannerLayoutView: View = LayoutInflater.from(
                viewGroup.context
            ).inflate(
                R.layout.banner_ad_container,
                viewGroup, false
            )
            AdViewHolder(bannerLayoutView)
        }
    }
}

//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val current = items[position]
////        holder.title.text=current.bookName
//
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        lateinit var adView: AdView
        when (viewType) {
            MENU_ITEM_VIEW_TYPE -> {
                var menuItemHolder: ItemViewHolder =
                    holder as ItemViewHolder
                val book: Books = items.get(position) as Books

               val name = book.bookName

                // Add the menu item details to the menu item view.
                menuItemHolder.title.text=name

            }
            BANNER_AD_VIEW_TYPE -> {
                if(position!=0){
                    val bannerHolder = holder as AdViewHolder
                    if(items.get(position) is AdView){
                        adView = items.get(position) as AdView
                        val adCardView = bannerHolder.itemView as ViewGroup
                        // The AdViewHolder recycled by the RecyclerView may be a different
                        // instance than the one used previously for this position. Clear the
                        // AdViewHolder of any subviews in case it has a different
                        // AdView associated with it, and make sure the AdView for this position doesn't
                        // already have a parent of a different recycled AdViewHolder.
                        if (adCardView.childCount > 0) {
                            adCardView.removeAllViews()
                        }
                        if (adView.parent != null) {
                            (adView.parent as ViewGroup).removeView(adView)
                        }

                        // Add the banner ad to the ad view.
                        adCardView.addView(adView)
                    }

                }
            }
            else -> {
                val bannerHolder = holder as AdViewHolder
                val adView = items.get(position) as AdView
                val adCardView = bannerHolder.itemView as ViewGroup
                if (adCardView.childCount > 0) {
                    adCardView.removeAllViews()
                }
                if (adView.parent != null) {
                    (adView.parent as ViewGroup).removeView(adView)
                }
                adCardView.addView(adView)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    companion object{
        private const val MENU_ITEM_VIEW_TYPE = 0

        // The banner ad view type.
        private const val BANNER_AD_VIEW_TYPE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % BitsatPyqFragment.ITEMS_PER_AD === 0) BANNER_AD_VIEW_TYPE else MENU_ITEM_VIEW_TYPE
    }
}
class ItemViewHolder (itemView: View ) :RecyclerView.ViewHolder(itemView){
    val title = itemView.findViewById<TextView>(R.id.title)
}
class AdViewHolder (itemView: View ) :RecyclerView.ViewHolder(itemView){

}
interface ItemClicked2{
    fun onClick(item: Any)
}