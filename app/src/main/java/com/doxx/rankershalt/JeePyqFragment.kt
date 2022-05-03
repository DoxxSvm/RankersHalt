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


class JeePyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
    lateinit var adapter:TestAdapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "JEE ADVANCED 2007 Paper 1",
            "JEE ADVANCED 2007 Paper 2",
            "JEE ADVANCED 2008 Paper 1",
            "JEE ADVANCED 2008 Paper 2",
            "JEE ADVANCED 2009 Paper 1",
            "JEE ADVANCED 2009 Paper 2",
            "JEE ADVANCED 2010 Paper 1",
            "JEE ADVANCED 2010 Paper 2",
            "JEE ADVANCED 2011 Paper 1",
            "JEE ADVANCED 2011 Paper 2",
            "JEE ADVANCED 2012 Paper 1",
            "JEE ADVANCED 2012 Paper 2",
            "JEE ADVANCED 2013 Paper 1",
            "JEE ADVANCED 2013 Paper 2",
            "JEE ADVANCED 2014 Paper 1",
            "JEE ADVANCED 2014 Paper 2",
            "JEE ADVANCED 2015 Paper 1",
            "JEE ADVANCED 2015 Paper 2",
            "JEE ADVANCED 2016 Paper 1",
            "JEE ADVANCED 2016 Paper 2",
            "JEE ADVANCED 2017 Paper 1",
            "JEE ADVANCED 2017 Paper 2",
            "JEE ADVANCED 2018 Paper 1",
            "JEE ADVANCED 2018 Paper 2",
            "JEE ADVANCED 2019 Paper 1",
            "JEE ADVANCED 2019 Paper 2",
            "JEE ADVANCED 2020 Paper 1",
            "JEE ADVANCED 2020 Paper 2",
            "JEE ADVANCED 2021 Paper 1",
            "JEE ADVANCED 2021 Paper 2",
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1_GpgJ-9ZthbhpsKmoD7uQJzlB5W2A0m4",
            "https://drive.google.com/uc?export=download&id=1Le9ZiWmOnNUePu1QIpI8Wx_1u7F19jQd",
            "https://drive.google.com/uc?export=download&id=1peY-VkmWEBxXnhNw2Mcj4WskZrI-QksZ",
            "https://drive.google.com/uc?export=download&id=1W-D3lPUYn0rinQwQa6Ez5NoRMox2iMyU",
            "https://drive.google.com/uc?export=download&id=1TgiE02xLh76oeEcPbrIupW-c7zABUNQH",
            "https://drive.google.com/uc?export=download&id=1j2RmcBvVGC9QICfEoJPD-k1r-EPliDQa",
            "https://drive.google.com/uc?export=download&id=1_4Mg25Vxcg4AkS-Q75WW3Kofn6e0vGwq",
            "https://drive.google.com/uc?export=download&id=1n4zYLs8UZ6MSbJTHHLKcEQeTmb-uFxIK",
            "https://drive.google.com/uc?export=download&id=1duwzsmEvnyOncDm2ynuWt2Ck1QGlK44x",
            "https://drive.google.com/uc?export=download&id=1eFlWlE6Zi08SLP6DL8m5R9Fy-6TfW-1z",
            "https://drive.google.com/uc?export=download&id=1LLx7ZUwxk1o7Ox-sK3uvCjZVi0SJk7WQ",
            "https://drive.google.com/uc?export=download&id=1tZObxm5g1523nHqgo044_VY8E2_nk5xH",
            "https://drive.google.com/uc?export=download&id=1htBo0y4LKU0BOxPMzbb8HVno3ZReQo7g",
            "https://drive.google.com/uc?export=download&id=1WDqj4bi4yS9yZAuH7H_tuWxuiUvjwyjI",
            "https://drive.google.com/uc?export=download&id=1d6_eaaQOiPwaTq3c-iObk5OWFj5Tp3Ns",
            "https://drive.google.com/uc?export=download&id=1lTq-TeeupXFWsBbq_OVeJViTKZsF6Vxm",
            "https://drive.google.com/uc?export=download&id=1J7OMcbQuIaOU5ur25Y5VlIXAktkqy3Pe",
            "https://drive.google.com/uc?export=download&id=1PrboEG_zRhWaqOje5YbIwW_3RA1ghGbd",
            "https://drive.google.com/uc?export=download&id=1A6NmHMRo-0aiiEAhOOIHLoZNUMS0kEVc",
            "https://drive.google.com/uc?export=download&id=1EYXoyjK7spsynIl0otOZ3AZo8U1oTzM3",
            "https://drive.google.com/uc?export=download&id=1vxUqnsciEaqphe6LaTlMS1PuB2gGh0eH",
            "https://drive.google.com/uc?export=download&id=1aB4vQEpJA6OJeDdKO-Q5FrIpoil2qKQn",
            "https://drive.google.com/uc?export=download&id=1gA5-H2e_jqADYRD_flvpF-zUZcS9FqFF",
            "https://drive.google.com/uc?export=download&id=1oAHirziTtBtMaTGvBPsQkM8_2CfhMfZX",
            "https://drive.google.com/uc?export=download&id=1TKRKdZkfKXAx0_HP-hVn-G0CxCJ1rhUn",
            "https://drive.google.com/uc?export=download&id=18LMPxSqch8SBSVlQYW0qM_spKnReDJMV",
            "https://drive.google.com/uc?export=download&id=1SuPJCgdxPh65EJutoSLQYmSvFSBL5IMY",
            "https://drive.google.com/uc?export=download&id=1ncySmOwAs8HOdj5g2cNr3QL-O72aeYdB",
            "https://drive.google.com/uc?export=download&id=1ewOu0EvXJHIHtjZMoWZzr20cmOWFdfYi",
            "https://drive.google.com/uc?export=download&id=1FkA4MDzeUMYxrHZC-BpEs0ffsWKvfwwk"

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