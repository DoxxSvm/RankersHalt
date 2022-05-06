package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeDppPhyFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Mathematical Tools DPP",
            "Rectilinear Motion DPP",
            "Rectilinear, Projectile and Relative Motion DPP",
            "Relative Motion and NLM DPP",
            "Friction and NLM DPP",
            "Friction and WPE DPP",
            "Relative Motion and WPE DPP",
            "WPE and Circular Motion DPP",
            "Circular Motion and Centre of Mass DPP",
            "Centre of Mass and WPE DPP",
            "Rigid Body Dynamics and NLM DPP",
            "Rigid Body Dynamics, Circular Motion and COM DPP",
            "Rigid Body Dynamics and WPE DPP",
            "Rigid Body Dynamics, SHM and WPE DPP",
            "SHM and NLM DPP",
            "Wave on a String, Circular Motion and COM DPP",
            "Wave on a String, WPE and Friction DPP",
            "Simple Harmonic Motion, Sound Wave DPP",
            "String, SHM,Wave on a String DPP",
            "Sound Waves, Sound, WPE DPP",
            "Elasticity and Plasticity DPP",
            "Variation of Strain DPP",
            "Viscosity DPP",
            "Stokes's Law DPP",
            "Electric charges and fields DPP",
            "Electrostatic potential and capapcitance DPP",
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
            "https://drive.google.com/uc?export=download&id=1exKVL4lXQt78MzGLdDyfyEpLE5SmUU7X",
            "https://drive.google.com/uc?export=download&id=17UqxdU4tKqXUGceozZfLiA0xGdDtBzsC",
            "https://drive.google.com/uc?export=download&id=12E1sqg8Jticx1yE4OpaxPlLPYkS3gzDq",
            "https://drive.google.com/uc?export=download&id=1F4NfWYWEKk70iTBAeVoNgj6yU6Ldf9ox",
            "https://drive.google.com/uc?export=download&id=1tC8KorwFG3LxGzZA9lzZTqrrBIcuMn0o",
            "https://drive.google.com/uc?export=download&id=1cuFwW0w_OaKdXDL1F02TRz5mYVXRC1Ct",
            "https://drive.google.com/uc?export=download&id=16FOwERv8ACmvB1gSlS_79qoNR4XXgkTB",
            "https://drive.google.com/uc?export=download&id=1VVlsZmrQUfi4tKwa4LefuAxLMBkD5KbH",
            "https://drive.google.com/uc?export=download&id=1p29eIhrK7lob_7twOo0yvFHHSK-VLpCF",
            "https://drive.google.com/uc?export=download&id=1Dv8dVTyXN0hPKH0-S6llxzpXU8lMmXWd",
            "https://drive.google.com/uc?export=download&id=1g3ieTF29ysmqaNxrzCFuFKv7_QC1e_Ld",
            "https://drive.google.com/uc?export=download&id=1CyLAbWbaGm8sSnEcbMGXzmbbjS3NoWpB",
            "https://drive.google.com/uc?export=download&id=1HPpONOeTgN3JVWJNOzWcArdLiGd-xcnT",
            "https://drive.google.com/uc?export=download&id=1AA4i_hHLf5mBO61NVoiGG4XyCkkqc1cR",
            "https://drive.google.com/uc?export=download&id=1qCxlV0e5Gzolc1ihRP6TpexM883k5wSr",
            "https://drive.google.com/uc?export=download&id=1Fj8TWpMyDnF3-Y0pfBV32YZiWw0LodR-",
            "https://drive.google.com/uc?export=download&id=1AvQJb0ldADR7pYpgOOrSTxVcTii5n4WA",
            "https://drive.google.com/uc?export=download&id=10NRBoQkKbEh0JRA531IWqmZ6Y0iWG8VY",
            "https://drive.google.com/uc?export=download&id=1Wgq4BsIVWjY1Rl-hk5ZaKC4D_eBnczJy",
            "https://drive.google.com/uc?export=download&id=1wcXx6t7T_I8UxFq9fUAAqsvkDb_CgGXV",
            "https://drive.google.com/uc?export=download&id=1MDMs5TmpDG1B7DSXNMlTRuq7qeECrvnR",
            "https://drive.google.com/uc?export=download&id=1McPTIAO4RofHA3HtfhdZHkii3s9tV6SG",
            "https://drive.google.com/uc?export=download&id=1Zwm8Xyd95PNKWCznZNJMblM3nI4QlNNc",
            "https://drive.google.com/uc?export=download&id=1Qgj83P2oUx2b1rV3U--r_F0x9RteoQ-9",
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
        var temp = ArrayList<Books>()
        temp.addAll(bookArrayList)
        adapter= Adapter(bookArrayList,this)
        ecy.adapter=adapter
        bookListSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextChange(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                if(search.isNotEmpty()){
                    var filter = ArrayList<Books>()
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
                var filter = ArrayList<Books>()
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
    fun fetchData(){
        for(i in bookName.indices){
            val book = Books(bookName[i],links[i])
            bookArrayList.add(book)
        }
    }

    companion object{
        const val ITEMS_PER_AD = 5

    }

    override fun onClick(item: Books) {

        val intent = Intent(context,Downloader::class.java)
        intent.putExtra("title",item.bookName)
        intent.putExtra("link",item.link)
        startActivity(intent)


    }
}
//class JeeDppPhyFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked2 {
//    lateinit var adapter:TestAdapter
//    lateinit var imageId:Array<Int>
//    lateinit var bookName:Array<String>
//    lateinit var links:Array<String>
//    lateinit var bookArrayList: ArrayList<Any>
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        ecy.layoutManager= LinearLayoutManager(context)
//
//        bookName= arrayOf(
//            "Mathematical Tools DPP",
//            "Rectilinear Motion DPP",
//            "Rectilinear, Projectile and Relative Motion DPP",
//            "Relative Motion and NLM DPP",
//            "Friction and NLM DPP",
//            "Friction and WPE DPP",
//            "Relative Motion and WPE DPP",
//            "WPE and Circular Motion DPP",
//            "Circular Motion and Centre of Mass DPP",
//            "Centre of Mass and WPE DPP",
//            "Rigid Body Dynamics and NLM DPP",
//            "Rigid Body Dynamics, Circular Motion and COM DPP",
//            "Rigid Body Dynamics and WPE DPP",
//            "Rigid Body Dynamics, SHM and WPE DPP",
//            "SHM and NLM DPP",
//            "Wave on a String, Circular Motion and COM DPP",
//            "Wave on a String, WPE and Friction DPP",
//            "Simple Harmonic Motion, Sound Wave DPP",
//            "String, SHM,Wave on a String DPP",
//            "Sound Waves, Sound, WPE DPP",
//            "Elasticity and Plasticity DPP",
//            "Variation of Strain DPP",
//            "Viscosity DPP",
//            "Stokes's Law DPP",
//            "Electric charges and fields DPP",
//            "Electrostatic potential and capacitance DPP",
//            "Current electricity DPP",
//            "Moving charges and magnetism DPP",
//            "Magnetism and matter DPP",
//            "Electromagnetic induction DPP",
//            "Alternating current DPP",
//            "Electromagnetic waves Ray optics and optical instrument DPP",
//            "Wave optics DPP",
//            "Dual nature of radiation and matter DPP",
//            "Atoms DPP",
//            "Nuclei DPP",
//            "Semiconductor electronics DPP"
//        )
//        links= arrayOf(
//            "https://drive.google.com/uc?export=download&id=1exKVL4lXQt78MzGLdDyfyEpLE5SmUU7X",
//            "https://drive.google.com/uc?export=download&id=17UqxdU4tKqXUGceozZfLiA0xGdDtBzsC",
//            "https://drive.google.com/uc?export=download&id=12E1sqg8Jticx1yE4OpaxPlLPYkS3gzDq",
//            "https://drive.google.com/uc?export=download&id=1F4NfWYWEKk70iTBAeVoNgj6yU6Ldf9ox",
//            "https://drive.google.com/uc?export=download&id=1tC8KorwFG3LxGzZA9lzZTqrrBIcuMn0o",
//            "https://drive.google.com/uc?export=download&id=1cuFwW0w_OaKdXDL1F02TRz5mYVXRC1Ct",
//            "https://drive.google.com/uc?export=download&id=16FOwERv8ACmvB1gSlS_79qoNR4XXgkTB",
//            "https://drive.google.com/uc?export=download&id=1VVlsZmrQUfi4tKwa4LefuAxLMBkD5KbH",
//            "https://drive.google.com/uc?export=download&id=1p29eIhrK7lob_7twOo0yvFHHSK-VLpCF",
//            "https://drive.google.com/uc?export=download&id=1Dv8dVTyXN0hPKH0-S6llxzpXU8lMmXWd",
//            "https://drive.google.com/uc?export=download&id=1g3ieTF29ysmqaNxrzCFuFKv7_QC1e_Ld",
//            "https://drive.google.com/uc?export=download&id=1CyLAbWbaGm8sSnEcbMGXzmbbjS3NoWpB",
//            "https://drive.google.com/uc?export=download&id=1HPpONOeTgN3JVWJNOzWcArdLiGd-xcnT",
//            "https://drive.google.com/uc?export=download&id=1AA4i_hHLf5mBO61NVoiGG4XyCkkqc1cR",
//            "https://drive.google.com/uc?export=download&id=1qCxlV0e5Gzolc1ihRP6TpexM883k5wSr",
//            "https://drive.google.com/uc?export=download&id=1Fj8TWpMyDnF3-Y0pfBV32YZiWw0LodR-",
//            "https://drive.google.com/uc?export=download&id=1AvQJb0ldADR7pYpgOOrSTxVcTii5n4WA",
//            "https://drive.google.com/uc?export=download&id=10NRBoQkKbEh0JRA531IWqmZ6Y0iWG8VY",
//            "https://drive.google.com/uc?export=download&id=1Wgq4BsIVWjY1Rl-hk5ZaKC4D_eBnczJy",
//            "https://drive.google.com/uc?export=download&id=1wcXx6t7T_I8UxFq9fUAAqsvkDb_CgGXV",
//            "https://drive.google.com/uc?export=download&id=1MDMs5TmpDG1B7DSXNMlTRuq7qeECrvnR",
//            "https://drive.google.com/uc?export=download&id=1McPTIAO4RofHA3HtfhdZHkii3s9tV6SG",
//            "https://drive.google.com/uc?export=download&id=1Zwm8Xyd95PNKWCznZNJMblM3nI4QlNNc",
//            "https://drive.google.com/uc?export=download&id=1Qgj83P2oUx2b1rV3U--r_F0x9RteoQ-9",
//            "https://drive.google.com/uc?export=download&id=1banrOQ2rAWyplXqEOmVPJmcbiYDRsAbQ",
//            "https://drive.google.com/uc?export=download&id=1iJfygSZUs7rfRuLBKLVXvcGFvP2sZvk2",
//            "https://drive.google.com/uc?export=download&id=1MCbyS4QhGYeyY7HELd-KS_fd2nggsdHE",
//            "https://drive.google.com/uc?export=download&id=1-auHzO9Ch23OJLQ0OxmHjX8NfxiK8ZnX",
//            "https://drive.google.com/uc?export=download&id=1nVPT-Xb9t4R9siInGf_n50up6Oz0Jipt",
//            "https://drive.google.com/uc?export=download&id=1r2cdKK_DsFjX4R4zl0uz1DY7RhXq6qEX",
//            "https://drive.google.com/uc?export=download&id=1YCi3oPcUGA9WUHNx15uaWlHMx5j246wX",
//            "https://drive.google.com/uc?export=download&id=1Ok0vwUYza_MSk86oiTkzi7HtVOuErybm",
//            "https://drive.google.com/uc?export=download&id=15wSwqAR4MIIfTdxJmUl-kbM4q_-ZFTL3",
//            "https://drive.google.com/uc?export=download&id=1jp-S4PLYQX4973EXHjgkyGZW5PFqYBke",
//            "https://drive.google.com/uc?export=download&id=1ivCFhiuDeNjdwdYN0CI01YAvneA7TpCu",
//            "https://drive.google.com/uc?export=download&id=1K47dWHbk1-yPWQHzpJ3QNj5C2lnEulPP",
//            "https://drive.google.com/uc?export=download&id=1rkIc8-4OhAAIG0gwyv1FBYjcs8f_sNkt",
//            "https://drive.google.com/uc?export=download&id=11xcr-8JAGvycnzXUh-U_8TWdyMh4BC-X"
//
//        )
//        bookArrayList= arrayListOf()
//        fetchData()
//        addBannerAds()
//        loadBannerAds()
//        var temp = ArrayList<Any>()
//        temp.addAll(bookArrayList)
//        adapter= TestAdapter(context,bookArrayList,this)
//        ecy.adapter=adapter
//        bookListSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                val search = p0!!.lowercase(Locale.getDefault())
//                if(search.isNotEmpty()){
//                    var filter = ArrayList<Any>()
//                    bookArrayList.forEach{
//                        if(it is Books){
//                            if(it.bookName.lowercase().contains(search)){
//                                filter.add(it)
//                            }
//                        }
//                    }
//                    adapter.items=filter
//                    adapter.notifyDataSetChanged()
//                }
//                else{
//                    adapter.items=temp
//                    adapter.notifyDataSetChanged()
//                }
//                return false
//            }
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                val search = p0!!.lowercase(Locale.getDefault())
//                var filter = ArrayList<Any>()
//                bookArrayList.forEach{
//                    if(it is Books){
//                        if(it.bookName.lowercase().contains(search)){
//                            filter.add(it)
//                        }
//                    }
//                }
//                adapter.items=filter
//                adapter.notifyDataSetChanged()
//                return false
//            }
//        })
//    }
//    private fun addBannerAds() {
//        var i = 0
//        while (i <= bookArrayList.size) {
//            val adView = AdView(context)
//            adView.adSize = AdSize.BANNER
//            adView.adUnitId = getString(R.string.Banner_ad_unit)
//            bookArrayList.add(i, adView)
//            i += ITEMS_PER_AD
//        }
//    }
//    fun fetchData(){
//        for(i in bookName.indices){
//            val book = Books(bookName[i],links[i])
//            bookArrayList.add(book)
//        }
//    }
//
//    override fun onClick(item: Any) {
//        if(item is Books){
//            val intent = Intent(context,Downloader::class.java)
//            intent.putExtra("title",item.bookName)
//            intent.putExtra("link",item.link)
//            startActivity(intent)
//        }
//
//    }
//    companion object{
//        const val ITEMS_PER_AD = 5
//
//    }
//
//    private fun loadBannerAd(index: Int) {
//        if (index >= bookArrayList.size) {
//            return
//        }
//        val item: Any = bookArrayList[index] as? AdView
//            ?: throw ClassCastException(
//                "Expected item at index " + index + " to be a banner ad"
//                        + " ad."
//            )
//        val adView = item as AdView
//
//        // Set an AdListener on the AdView to wait for the previous banner ad
//        // to finish loading before loading the next ad in the items list.
//        adView.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                super.onAdLoaded()
//                // The previous banner ad loaded successfully, call this method again to
//                // load the next ad in the items list.
//                loadBannerAd(index + ITEMS_PER_AD)
//            }
//
//            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
//                // The previous banner ad failed to load. Call this method again to load
//                // the next ad in the items list.
//                val error = String.format(
//                    "domain: %s, code: %d, message: %s",
//                    loadAdError.domain, loadAdError.code, loadAdError.message
//                )
//                Log.e(
//                    "MainActivity",
//                    "The previous banner ad failed to load with error: "
//                            + error
//                            + ". Attempting to"
//                            + " load the next banner ad in the items list."
//                )
//                loadBannerAd(index + ITEMS_PER_AD)
//            }
//        }
//        // Load the banner ad.
//        adView.loadAd(AdRequest.Builder().build())
//    }
//    private fun loadBannerAds() {
//        // Load the first banner ad in the items list (subsequent ads will be loaded automatically
//        // in sequence).
//        loadBannerAd(5)
//    }
//    override fun onResume() {
//        for (item in bookArrayList) {
//            if (item is AdView) {
//                item.resume()
//            }
//        }
//        super.onResume()
//    }
//
//    override fun onPause() {
//        for (item in bookArrayList) {
//            if (item is AdView) {
//                item.pause()
//            }
//        }
//        super.onPause()
//    }
//
//    override fun onDestroy() {
//        for (item in bookArrayList) {
//            if (item is AdView) {
//                item.destroy()
//            }
//        }
//        super.onDestroy()
//    }
//}