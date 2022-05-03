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


class VitTestPaperFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
    lateinit var adapter:TestAdapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Electric charges and fields DPP",
            "Electrostatic potential and capacitance DPP",
            "Current electricity DPP",
            "Moving charges and magnetism DPP",
            "Magnetism and matter DPP",
            "Electromagnetic induction DPP",
            "Alternating current DPP",
            "Electromagnetic waves Ray optics and optical instrument DPP",
            "Wave optics DPP",
            "Dual nature of radiation and matter DPP",
            "Atoms DPP",
            "Nuclei DPP",
            "Semiconductor electronics DPP"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1banrOQ2rAWyplXqEOmVPJmcbiYDRsAbQ",
            "https://drive.google.com/uc?export=download&id=1iJfygSZUs7rfRuLBKLVXvcGFvP2sZvk2",
            "https://drive.google.com/uc?export=download&id=1MCbyS4QhGYeyY7HELd-KS_fd2nggsdHE",
            "https://drive.google.com/uc?export=download&id=1-auHzO9Ch23OJLQ0OxmHjX8NfxiK8ZnX",
            "https://drive.google.com/uc?export=download&id=1nVPT-Xb9t4R9siInGf_n50up6Oz0Jipt",
            "https://drive.google.com/uc?export=download&id=1r2cdKK_DsFjX4R4zl0uz1DY7RhXq6qEX",
            "https://drive.google.com/uc?export=download&id=1YCi3oPcUGA9WUHNx15uaWlHMx5j246wX",
            "https://drive.google.com/uc?export=download&id=1Ok0vwUYza_MSk86oiTkzi7HtVOuErybm",
            "https://drive.google.com/uc?export=download&id=15wSwqAR4MIIfTdxJmUl-kbM4q_-ZFTL3",
            "https://drive.google.com/uc?export=download&id=1jp-S4PLYQX4973EXHjgkyGZW5PFqYBke",
            "https://drive.google.com/uc?export=download&id=1ivCFhiuDeNjdwdYN0CI01YAvneA7TpCu",
            "https://drive.google.com/uc?export=download&id=1K47dWHbk1-yPWQHzpJ3QNj5C2lnEulPP",
            "https://drive.google.com/uc?export=download&id=1rkIc8-4OhAAIG0gwyv1FBYjcs8f_sNkt",
            "https://drive.google.com/uc?export=download&id=11xcr-8JAGvycnzXUh-U_8TWdyMh4BC-X"

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