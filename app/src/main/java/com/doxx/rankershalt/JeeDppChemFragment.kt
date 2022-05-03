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


class JeeDppChemFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
    lateinit var adapter:TestAdapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Atomic Structure DPP",
            "Basic Inorganic Chemistry DPP",
            "Chemical Bonding DPP",
            "Chemical Equilibrium DPP",
            "Gaseous State DPP",
            "General Organic Chemistry DPP",
            "IUPAC Nomenclature & Isomerism DPP",
            "Mole Concept DPP",
            "P-Block Elements (Boron and Carbon Family) DPP",
            "Periodic Table and Periodicity DPP",
            "S-block Elements DPP",
            "Thermodynamics and Thermochemistry DPP",
            "The Solid State DPP",
            "Solutions DPP",
            "Electrochemistry DPP",
            "Chemical Kinetics DPP",
            "Surface Chemistry DPP",
            "Metallurgy DPP",
            "p-Block Elements DPP",
            "d-and f-Block Elements DPP",
            "Coordination Compounds DPP",
            "Haloalkanes and Haloarenes DPP",
            "Alcohols, Phenols and Ethers DPP",
            "Aldehydes, Ketones and carboxylic acids DPP",
            "Amines DPP",
            "Biomolecules DPP",
            "Polymers DPP",
            "Chemistry In everyday life DPP",
            "Salt analysis DPP"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=18SdyZvmsvoKD-9zNc-whGfJmDsptbtEb",
            "https://drive.google.com/uc?export=download&id=1sG42wdqQHbhjYSW-n524THx1Vlc6lW8I",
            "https://drive.google.com/uc?export=download&id=10a1Pvaa68KY_YVUdna8y4jbxa-6leLEz",
            "https://drive.google.com/uc?export=download&id=14Se_jv6A3JlKTHIxyOUHlVvxvOuQGWsv",
            "https://drive.google.com/uc?export=download&id=12lJ9lFozejUvLWo95vI6iie4wZxVLHf1",
            "https://drive.google.com/uc?export=download&id=1exObMcNr7ANVtejS2daRyImYpuW5Qydy",
            "https://drive.google.com/uc?export=download&id=1tEbDeeR4EHgnyPWg2qlnDJNsweeFRIp2",
            "https://drive.google.com/uc?export=download&id=1sogFLrxcXgr5Jb2iSzKJs9z08slCpWo2",
            "https://drive.google.com/uc?export=download&id=168Z5IAzdGBbm5PR6TO1YYIXZMveC0SEV",
            "https://drive.google.com/uc?export=download&id=1AngKpU9w5XYjesrrtuBC6V2sRthoXxIj",
            "https://drive.google.com/uc?export=download&id=1Ps7N3PGztaOTGHqPHxMgZBCL9wo8YSYc",
            "https://drive.google.com/uc?export=download&id=1U0Kl3-Pi2gZ_h77So1EXh37j0HlDwedQ",
            "https://drive.google.com/u/0/uc?id=14Zg3IqpCHJ1IH-7SIlrTNPDZZTNttl3D&export=download",
            "https://drive.google.com/uc?export=download&id=1xJbpXiyzpjtdqbJlBNss6iAWNqlwSSSa",
            "https://drive.google.com/uc?export=download&id=1e0jcF-BMVeg_MsW_7oKQd9w9E_BIi0e3",
            "https://drive.google.com/uc?export=download&id=1covCMV3jtD9NLFYdKdp4hxJw7hAUUp7Y",
            "https://drive.google.com/uc?export=download&id=1ng1gc_25w1rKJKO42WIfsbKq8NvVHXFz",
            "https://drive.google.com/uc?export=download&id=1y7zuihvAxmEwDV1Ho8DXRF6aIiYTdM-q",
            "https://drive.google.com/uc?export=download&id=1NCA2Hdm4ZrzLDkwpOhlcPBxamhsDpBnr",
            "https://drive.google.com/uc?export=download&id=1wq4GJ7Lw7gH7koqawa1ePpOvFZOGqVgG",
            "https://drive.google.com/uc?export=download&id=1LK7zlANp-9XhrwT5m7O3PAyoLOGaxvwn",
            "https://drive.google.com/uc?export=download&id=1CllTMkTpb0kprNR0dXyiG6CzvQZXSQWy",
            "https://drive.google.com/uc?export=download&id=1xMX5L78axxix0IumGm-sv6lJSOGvnPCq",
            "https://drive.google.com/uc?export=download&id=1dY5n2C6g1DrbrlNz0BPHmfQhYqCpfwaL",
            "https://drive.google.com/uc?export=download&id=1lUAl07ZZXErKwJ6Bxe4jXFVsJnq6wML9",
            "https://drive.google.com/uc?export=download&id=17kDmJtNZNvqdPHZBFqyUpAONxjWnzA__",
            "https://drive.google.com/uc?export=download&id=1hVBNQNIZcGdbS8EIuPc66lEFD40z1tsy",
            "https://drive.google.com/uc?export=download&id=1WCe279k0hy2oL-3f7sx9sE7_df46qVfA",
            "https://drive.google.com/uc?export=download&id=1waRIGa80lpdZPPaEe2DTaFifS1qoxJ00"

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