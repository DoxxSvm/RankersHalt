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


class JeeDppMathsFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
    lateinit var adapter:TestAdapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Relations and functions DPP",
            "Inverse trigonometric functions DPP",
            "Matrices DPP",
            "Determinants DPP",
            "Continuity and derivatives DPP",
            "Application of Derivatives DPP",
            "Integrals DPP",
            "Application of integrals DPP",
            "Differential equations Vector DPP", "algebra DPP",
            "3-D Geometry DPP",
            "Linear programming DPP",
            "Probability DPP"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1-d_Er_FwlnIDWaM91-AUcWDPzH4kCsQ2",
            "https://drive.google.com/uc?export=download&id=1rbz9-hQ1rQUems0Vh9P6rcTxVuLJgeCY",
            "https://drive.google.com/uc?export=download&id=16RvHg_avGH28IoZsDYyGZjXpAsM2WS_A",
            "https://drive.google.com/uc?export=download&id=1V8_ixu4uaYIfzU4UoJAtIF9GuUPFUzRm",
            "https://drive.google.com/uc?export=download&id=1bPIes_AKxcnQnL344-GcXsV_yePorUe5",
            "https://drive.google.com/uc?export=download&id=1GVr8hQtm7m15kjTm5LrtMMygK_8VZvoY",
            "https://drive.google.com/uc?export=download&id=1R_kzI1r3V7-aGKY2XvqlW2DIecmcjC-v",
            "https://drive.google.com/uc?export=download&id=1xlhEhgegOnW-mRM3X4Ilhpbvlf-kx-am",
            "https://drive.google.com/uc?export=download&id=13KWl4-W0aawT52R6FHTVAZAWowp67Nk9",
            "https://drive.google.com/uc?export=download&id=1nR1qPTRC_G40rwg1WVf_sYGGIKUFsQn-",
            "https://drive.google.com/uc?export=download&id=1D4UXVayljdzCqPpWJ25oDkOpjL2xDzwB",
            "https://drive.google.com/uc?export=download&id=1ZylQ5sX-593Fkj8oqigkTA_6EizU9rTp",
            "https://drive.google.com/uc?export=download&id=1vQxaEnejl72mcnOA9j_Usg9SKnj7Ovcm"

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