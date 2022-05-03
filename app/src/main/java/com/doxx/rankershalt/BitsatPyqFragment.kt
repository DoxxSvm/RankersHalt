package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*


class BitsatPyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
    lateinit var adapter:TestAdapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "BITSAT 2005 Question Paper with solution",
            "BITSAT 2006 Question Paper with solution",
            "BITSAT 2007 Question Paper with solution",
            "BITSAT 2008 Question Paper with solution",
            "BITSAT 2009 Question Paper with solution",
            "BITSAT 2010 Question Paper with solution",
            "BITSAT 2011 Question Paper with solution",
            "BITSAT 2012 Question Paper with solution",
            "BITSAT 2013 Question Paper with solution",
            "BITSAT 2014 Question Paper with solution",
            "BITSAT 2015 Question Paper with solution",
            "BITSAT 2016 Question Paper with solution",
            "BITSAT 2017 Question Paper with solution",
            "BITSAT 2018 Question Paper with solution"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1AE9H2NEVWMLBsCeRqVQQiuVNXuSe3dNb",
            "https://drive.google.com/uc?export=download&id=16_XpEPYkeV3ObO3Vqh6BF7oJMYB1MOkX",
            "https://drive.google.com/uc?export=download&id=1_L0c74I38lKt4uv_D4JSBM630YPHtupg",
            "https://drive.google.com/uc?export=download&id=1TVA_LhxHWdaSI8uQJxZuoBD4nw4NvPBY",
            "https://drive.google.com/uc?export=download&id=1NfJRoifoyyVyxQXFR735SctgjKSm6Qdj",
            "https://drive.google.com/uc?export=download&id=1OSmgY7J6fL65fQxDBwARkcjwdKJZheet",
            "https://drive.google.com/uc?export=download&id=1vQOuD1IMJXd58au6TSLyDktnKeTvDsWt",
            "https://drive.google.com/uc?export=download&id=1owv8ob8sScvkcfAJrYhukzNENrRw_hDf",
            "https://drive.google.com/uc?export=download&id=1xgauPA1UzEc8ThQDq7v51j6EyRkI0Gii",
            "https://drive.google.com/uc?export=download&id=1-UEkQrYe5UCmSx2vBeFjmx94ZKE4g3I7",
            "https://drive.google.com/uc?export=download&id=1XRhh5LKfGwrBD4FkXtIRAGtctNCT1etU",
            "https://drive.google.com/uc?export=download&id=1G6jxPb26fQr3zab9bcBLkn79WjlevIf9",
            "https://drive.google.com/uc?export=download&id=1P4O5X15PAqxrxnD_yMXS4DFgqpLE6yaf",
            "https://drive.google.com/uc?export=download&id=1GZxxHBf6VBe01Xo42XrNsYktGqbYMxy-"

        )
        bookArrayList= arrayListOf()
        fetchData()
        addBannerAds()
        loadBannerAds()
        var temp = ArrayList<Any>()
        temp.addAll(bookArrayList)
        adapter= TestAdapter(context,bookArrayList,this)
        ecy.adapter=adapter
        bookListSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextChange(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                if(search.isNotEmpty()){
                    var filter = ArrayList<Any>()
                    bookArrayList.forEach{
                        if(it is Books){
                            if(it.bookName.lowercase().contains(search)){
                                filter.add(it)
                            }
                        }
                    }
                    adapter.items=filter
                    adapter.notifyDataSetChanged()
                }
                else{
                    adapter.items=temp
                    adapter.notifyDataSetChanged()
                }
                return false
            }
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                var filter = ArrayList<Any>()
                bookArrayList.forEach{
                    if(it is Books){
                        if(it.bookName.lowercase().contains(search)){
                            filter.add(it)
                        }
                    }
                }
                adapter.items=filter
                adapter.notifyDataSetChanged()
                return false
            }
        })
    }
    private fun addBannerAds() {
        var i = 0
        while (i <= bookArrayList.size) {
            val adView = AdView(context)
            adView.adSize = AdSize.BANNER
            adView.adUnitId = getString(R.string.Banner_ad_unit)
            bookArrayList.add(i, adView)
            i += ITEMS_PER_AD
        }
    }
    fun fetchData(){
        for(i in bookName.indices){
            val book = Books(bookName[i],links[i])
            bookArrayList.add(book)
        }
    }

    override fun onClick(item: Any) {
        if(item is Books){
            val intent = Intent(context,PdfView::class.java)
            intent.putExtra("title",item.bookName)
            intent.putExtra("link",item.link)
            startActivity(intent)
        }

    }
    companion object{
        const val ITEMS_PER_AD = 5

    }

    private fun loadBannerAd(index: Int) {
        if (index >= bookArrayList.size) {
            return
        }
        val item: Any = bookArrayList[index] as? AdView
            ?: throw ClassCastException(
                "Expected item at index " + index + " to be a banner ad"
                        + " ad."
            )
        val adView = item as AdView

        // Set an AdListener on the AdView to wait for the previous banner ad
        // to finish loading before loading the next ad in the items list.
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                // The previous banner ad loaded successfully, call this method again to
                // load the next ad in the items list.
                loadBannerAd(index + ITEMS_PER_AD)
            }

            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                // The previous banner ad failed to load. Call this method again to load
                // the next ad in the items list.
                val error = String.format(
                    "domain: %s, code: %d, message: %s",
                    loadAdError.domain, loadAdError.code, loadAdError.message
                )
                Log.e(
                    "MainActivity",
                    "The previous banner ad failed to load with error: "
                            + error
                            + ". Attempting to"
                            + " load the next banner ad in the items list."
                )
                loadBannerAd(index + ITEMS_PER_AD)
            }
        }
        // Load the banner ad.
        adView.loadAd(AdRequest.Builder().build())
    }
    private fun loadBannerAds() {
        // Load the first banner ad in the items list (subsequent ads will be loaded automatically
        // in sequence).
        loadBannerAd(5)
    }
    override fun onResume() {
        for (item in bookArrayList) {
            if (item is AdView) {
                item.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in bookArrayList) {
            if (item is AdView) {
                item.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in bookArrayList) {
            if (item is AdView) {
                item.destroy()
            }
        }
        super.onDestroy()
    }
}