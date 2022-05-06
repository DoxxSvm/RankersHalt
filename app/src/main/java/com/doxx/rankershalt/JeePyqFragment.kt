package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeePyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "JEE ADVANCED 2021 Paper 2",
            "JEE ADVANCED 2021 Paper 1",
            "JEE ADVANCED 2020 Paper 2",
            "JEE ADVANCED 2020 Paper 1",
            "JEE ADVANCED 2019 Paper 2",
            "JEE ADVANCED 2019 Paper 1",
            "JEE ADVANCED 2018 Paper 2",
            "JEE ADVANCED 2018 Paper 1",
            "JEE ADVANCED 2017 Paper 2",
            "JEE ADVANCED 2017 Paper 1",
            "JEE ADVANCED 2016 Paper 2",
            "JEE ADVANCED 2016 Paper 1",
            "JEE ADVANCED 2015 Paper 2",
            "JEE ADVANCED 2015 Paper 1",
            "JEE ADVANCED 2014 Paper 2",
            "JEE ADVANCED 2014 Paper 1",
            "JEE ADVANCED 2013 Paper 2",
            "JEE ADVANCED 2013 Paper 1",
            "JEE ADVANCED 2012 Paper 2",
            "JEE ADVANCED 2012 Paper 1",
            "JEE ADVANCED 2011 Paper 2",
            "JEE ADVANCED 2011 Paper 1",
            "JEE ADVANCED 2010 Paper 2",
            "JEE ADVANCED 2010 Paper 1",
            "JEE ADVANCED 2009 Paper 2",
            "JEE ADVANCED 2009 Paper 1",
            "JEE ADVANCED 2008 Paper 2",
            "JEE ADVANCED 2008 Paper 1",
            "JEE ADVANCED 2007 Paper 2",
            "JEE ADVANCED 2007 Paper 1",
            "Jee Main QP 2021 Feb 24 Shift 1",
            "Jee Main QP 2021 Feb 24 Shift 2",
            "Jee Main QP 2021 Feb 25 Shift 1",
            "Jee Main QP 2021 Feb 25 Shift 2",
            "Jee Main QP 2021 Feb 26 Shift 1",
            "Jee Main QP 2021 Feb 26 Shift 2",
            "Jee Main QP 2021 Mar 16 Shift 1",
            "Jee Main QP 2021 Mar 16 Shift 2",
            "Jee Main QP 2021 Mar 17 Shift 1",
            "Jee Main QP 2021 Mar 17 Shift 2",
            "Jee Main QP 2021 Mar 18 Shift 1",
            "Jee Main QP 2021 Mar 18 Shift 2",
            "Jee Main QP 2021 Jul 20 Shift 1",
            "Jee Main QP 2021 Jul 20 Shift 2",
            "Jee Main QP 2021 Jul 22 Shift 2",
            "Jee Main QP 2021 Jul 25 Shift 1",
            "Jee Main QP 2021 Jul 25 Shift 2",
            "Jee Main QP 2021 Jul 27 Shift 1",
            "Jee Main QP 2021 Jul 27 Shift 2",
            "Jee Main QP 2021 Aug 26 Shift 1",
            "Jee Main QP 2021 Aug 26 Shift 2",
            "Jee Main QP 2021 Aug 27 Shift 1",
            "Jee Main QP 2021 Aug 27 Shift 2",
            "Jee Main QP 2021 Aug 31 Shift 1",
            "Jee Main QP 2021 Aug 31 Shift 2",
            "Jee Main QP 2021 Sep 01 Shift 2",
            "JEE Main 2020 QP 01",
            "JEE Main 2020 QP 02",
            "JEE Main 2020 QP 03",
            "JEE Main 2020 QP 04",
            "JEE Main 2020 QP 05",
            "JEE Main 2020 QP 06",
            "JEE Main 2020 QP 07",
            "JEE Main 2020 QP 08",
            "JEE Main 2020 QP 09",
            "JEE Main 2020 QP 10",
            "JEE Main 2020 QP 11",
            "JEE Main 2020 QP 12",
            "JEE Main 2020 QP 13",
            "JEE Main 2020 QP 14",
            "JEE Main 2020 QP 15",
            "JEE Main 2020 QP 16",
            "JEE Main 2019 QP 01",
            "JEE Main 2019 QP 02",
            "JEE Main 2019 QP 03",
            "JEE Main 2019 QP 04",
            "JEE Main 2019 QP 05",
            "JEE Main 2019 QP 06",
            "JEE Main 2019 QP 07",
            "JEE Main 2019 QP 08",
            "JEE Main 2019 QP 09",
            "JEE Main 2019 QP 10",
            "JEE Main 2019 QP 11",
            "JEE Main 2019 QP 12",
            "JEE Main 2019 QP 13",
            "JEE Main 2019 QP 14",
            "JEE Main 2019 QP 15",
            "JEE Main 2019 QP 16",
            "JEE Main 2018 Question Paper",
            "JEE Main 2017 Question Paper",
            "JEE Main 2016 Question Paper",
            "JEE Main 2015 Question Paper",
            "JEE Main 2014 Question Paper",
            "JEE Main 2013 Question Paper",
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1FkA4MDzeUMYxrHZC-BpEs0ffsWKvfwwk",
            "https://drive.google.com/uc?export=download&id=1ewOu0EvXJHIHtjZMoWZzr20cmOWFdfYi",
            "https://drive.google.com/uc?export=download&id=1ncySmOwAs8HOdj5g2cNr3QL-O72aeYdB",
            "https://drive.google.com/uc?export=download&id=1SuPJCgdxPh65EJutoSLQYmSvFSBL5IMY",
            "https://drive.google.com/uc?export=download&id=18LMPxSqch8SBSVlQYW0qM_spKnReDJMV",
            "https://drive.google.com/uc?export=download&id=1TKRKdZkfKXAx0_HP-hVn-G0CxCJ1rhUn",
            "https://drive.google.com/uc?export=download&id=1oAHirziTtBtMaTGvBPsQkM8_2CfhMfZX",
            "https://drive.google.com/uc?export=download&id=1gA5-H2e_jqADYRD_flvpF-zUZcS9FqFF",
            "https://drive.google.com/uc?export=download&id=1aB4vQEpJA6OJeDdKO-Q5FrIpoil2qKQn",
            "https://drive.google.com/uc?export=download&id=1vxUqnsciEaqphe6LaTlMS1PuB2gGh0eH",
            "https://drive.google.com/uc?export=download&id=1EYXoyjK7spsynIl0otOZ3AZo8U1oTzM3",
            "https://drive.google.com/uc?export=download&id=1A6NmHMRo-0aiiEAhOOIHLoZNUMS0kEVc",
            "https://drive.google.com/uc?export=download&id=1PrboEG_zRhWaqOje5YbIwW_3RA1ghGbd",
            "https://drive.google.com/uc?export=download&id=1J7OMcbQuIaOU5ur25Y5VlIXAktkqy3Pe",
            "https://drive.google.com/uc?export=download&id=1lTq-TeeupXFWsBbq_OVeJViTKZsF6Vxm",
            "https://drive.google.com/uc?export=download&id=1d6_eaaQOiPwaTq3c-iObk5OWFj5Tp3Ns",
            "https://drive.google.com/uc?export=download&id=1WDqj4bi4yS9yZAuH7H_tuWxuiUvjwyjI",
            "https://drive.google.com/uc?export=download&id=1htBo0y4LKU0BOxPMzbb8HVno3ZReQo7g",
            "https://drive.google.com/uc?export=download&id=1tZObxm5g1523nHqgo044_VY8E2_nk5xH",
            "https://drive.google.com/uc?export=download&id=1LLx7ZUwxk1o7Ox-sK3uvCjZVi0SJk7WQ",
            "https://drive.google.com/uc?export=download&id=1eFlWlE6Zi08SLP6DL8m5R9Fy-6TfW-1z",
            "https://drive.google.com/uc?export=download&id=1duwzsmEvnyOncDm2ynuWt2Ck1QGlK44x",
            "https://drive.google.com/uc?export=download&id=1n4zYLs8UZ6MSbJTHHLKcEQeTmb-uFxIK",
            "https://drive.google.com/uc?export=download&id=1_4Mg25Vxcg4AkS-Q75WW3Kofn6e0vGwq",
            "https://drive.google.com/uc?export=download&id=1j2RmcBvVGC9QICfEoJPD-k1r-EPliDQa",
            "https://drive.google.com/uc?export=download&id=1TgiE02xLh76oeEcPbrIupW-c7zABUNQH",
            "https://drive.google.com/uc?export=download&id=1W-D3lPUYn0rinQwQa6Ez5NoRMox2iMyU",
            "https://drive.google.com/uc?export=download&id=1peY-VkmWEBxXnhNw2Mcj4WskZrI-QksZ",
            "https://drive.google.com/uc?export=download&id=1Le9ZiWmOnNUePu1QIpI8Wx_1u7F19jQd",
            "https://drive.google.com/uc?export=download&id=1_GpgJ-9ZthbhpsKmoD7uQJzlB5W2A0m4",
            "https://drive.google.com/uc?export=download&id=1Sgqt5yLjFkrOq9CUZM9ukHgtynMmLLQ3",
            "https://drive.google.com/uc?export=download&id=1B0tle0i4A7TNDAcgShLryUEIN9yrLCJd",
            "https://drive.google.com/uc?export=download&id=1OI0XtGGzN5KQe2RVYFWqXsfGBAOJB8qr",
            "https://drive.google.com/uc?export=download&id=1xMJE4p8PiYtZuRCFvVWbJ0Ilh3h5dQJ8",
            "https://drive.google.com/uc?export=download&id=1LhCroKey50sX35W5cGC6fIkcAs5UTanK",
            "https://drive.google.com/uc?export=download&id=1psI0iRYW2lLJuwB7-nv9ZuQPTu69co4-",
            "https://drive.google.com/uc?export=download&id=11EJ3GeUOdXp9Dy8LYaQVWfuSV4DA73jC",
            "https://drive.google.com/uc?export=download&id=1ZmhM2tv1lu17WyaPtjCp7NSjeteE4lhf",
            "https://drive.google.com/uc?export=download&id=1XjlmKcJgpDzB5vSW3xjY5P-MSnghzm8E",
            "https://drive.google.com/uc?export=download&id=1PFDRk5etkVJZ1pc2kOYT_hyvWeJxFNxO",
            "https://drive.google.com/uc?export=download&id=1HEeLWLWiknHiNDV-u3JJJ2f1jDN-bYL-",
            "https://drive.google.com/uc?export=download&id=1Pv69xOauS251WcvJqW1_V__BGo5q9jBH",
            "https://drive.google.com/uc?export=download&id=1JddloHqbvWS48uUo8xPiMO9GWIDG0VXB",
            "https://drive.google.com/uc?export=download&id=1DM2R-bpFtj1oC4DNdlOOByzqGT6of8MZ",
            "https://drive.google.com/uc?export=download&id=1WN1XOdBOzrcRUpmxUQXuiuBVN2Ke8A5u",
            "https://drive.google.com/uc?export=download&id=1G3sVCUc7wIPIxyQUa6cNBlKZlmQGb_48",
            "https://drive.google.com/uc?export=download&id=1UWRv-dsXjjFjwfcIoaOeEmUQcyB_-GDZ",
            "https://drive.google.com/uc?export=download&id=1hAtyXMXeHhKP75NpRnUwyEQ1fIuwQUrM",
            "https://drive.google.com/uc?export=download&id=1oDPm6ToAMMJrr71D4Ivf4uslVKrextDs",
            "https://drive.google.com/uc?export=download&id=1mhD1EL8-yWlBgza1Zdc8lRzl6aI1v1GD",
            "https://drive.google.com/uc?export=download&id=1akiQUx69cDdAKbLHdB0En6ViDoQ0drE-",
            "https://drive.google.com/uc?export=download&id=1MDGF9rTV9hNa7okM0GEMb-pg9f-tSIJ0",
            "https://drive.google.com/uc?export=download&id=1fePOIC905uHjs6b6WDVoDWsp6F_ftOQq",
            "https://drive.google.com/uc?export=download&id=1bQY4FzdZ7qgo_QKZcsgznJpAGF0WhDFB",
            "https://drive.google.com/uc?export=download&id=1YCO9XW9sizgoKTf0tONejCOjjjVepjK7",
            "https://drive.google.com/uc?export=download&id=1CRTDrX9hyz18Ij52jsB8zrnGqM6LgRm9",
            "https://drive.google.com/uc?export=download&id=1VoxpQJ-oe4CbwJ6RjSaxCQAxRdp8p7uz",
            "https://drive.google.com/uc?export=download&id=10v-veIjnHU_guMNCIPGopyUc6OQndr7R",
            "https://drive.google.com/uc?export=download&id=1DnLjUt69Z-7pyDm5l2REomGA3h6RXYpQ",
            "https://drive.google.com/uc?export=download&id=1DcN4g1Nu_0e_IhabhEqoOIhgwklyadFq",
            "https://drive.google.com/uc?export=download&id=1i_-n5jhskHxEUZpr7PvKMPvS5cX8rcQC",
            "https://drive.google.com/uc?export=download&id=1HkRYK1KliKboo8FP6pb4T5sWW1LE8ZEM",
            "https://drive.google.com/uc?export=download&id=1SbePKh74UU-zmW7e4Pl816jHVTq1u90s",
            "https://drive.google.com/uc?export=download&id=1FCtU5Uw6hAb5ES830BvY310zCccnyDvk",
            "https://drive.google.com/uc?export=download&id=19UwKBtIMrxr8rCpq6mUNHKcKTIbMpBGY",
            "https://drive.google.com/uc?export=download&id=1ONrnN_WhIQU1Zj20fwfvIW7EbFYFVpzp",
            "https://drive.google.com/uc?export=download&id=1t_WUGjmNqLkfPMj6EP7jnNfFpp-FBLeO",
            "https://drive.google.com/uc?export=download&id=15rDfbHkZQkEjJZ9blp452tNNoI-p86ss",
            "https://drive.google.com/uc?export=download&id=11V7P2OYVQVRSwPEeGS-v3BFcLUIUuCv_",
            "https://drive.google.com/uc?export=download&id=1IH_82TUquXDQ-wZL1RHpdVVgDc6FRy4t",
            "https://drive.google.com/uc?export=download&id=1Z0DQpWFcRk0nlGDJ_iIm77uZGOyCNTa4",
            "https://drive.google.com/uc?export=download&id=1VEz9ZSN8Ep5s1bN3iI1p8o6R2iX0syAF",
            "https://drive.google.com/uc?export=download&id=1XqGDaPh2xk1ieGTIuMA3wAZIYzcG9gAB",
            "https://drive.google.com/uc?export=download&id=1_Z8wghXzIiyqU10NTvLY6IJS1zUsVJb9",
            "https://drive.google.com/uc?export=download&id=19vnBTZCOUg2ugbyqclSJRO5BbFiX7Kh6",
            "https://drive.google.com/uc?export=download&id=1PdpDzUSDuXgd8lCNkLXcjUPcjCqa1Ppk",
            "https://drive.google.com/uc?export=download&id=1mAVbZ9hO6OUd39V9w5LCvKOeVlcx0hTK",
            "https://drive.google.com/uc?export=download&id=1hINiyljAAAs581qkHUGc0_2kcDKd9ULz",
            "https://drive.google.com/uc?export=download&id=1NSJ7ng7VskUNdLhmdNNXFiKP3l5yHi5E",
            "https://drive.google.com/uc?export=download&id=1Gl5qJ1vXG5TOFC8IyXZ5Oe1DR7W2rzxn",
            "https://drive.google.com/uc?export=download&id=12dp_N0VkelBxImVSp3z4zpRcDVdXclJ-",
            "https://drive.google.com/uc?export=download&id=1Jji1hW-9Q8YgowhdsRNzEZdApVgmDLCq",
            "https://drive.google.com/uc?export=download&id=1t68kBUa6sWO_k9NmT74Zq1_B6v6PNpBT",
            "https://drive.google.com/uc?export=download&id=1L5jMvtzo013-9_BMRmWZ-VHVhZluCboh",
            "https://drive.google.com/uc?export=download&id=19c4_JUCiWdu1CFBSrib8AMaMmYxyOpEk",
            "https://drive.google.com/uc?export=download&id=1AGVcv-J006AvulXr13BgzdBXoDIcvg0z",
            "https://drive.google.com/uc?export=download&id=1AgoZWqPpqpSHYSxdS_atdG8SJ7hfp35d",
            "https://drive.google.com/uc?export=download&id=114z3PMdG8PeFmefuybVsBcVI23bAxt1-",
            "https://drive.google.com/uc?export=download&id=1oJDxrmYYABvmciLplYMCQ2LYcQuMA4GI",
            "https://drive.google.com/uc?export=download&id=1fMzml-yi4Rv2nsxm7P6BJrAJacqVDqC-",
            "https://drive.google.com/uc?export=download&id=1p5LVCQFp3Sb2jBky6FurX0my1eUanXXY",
            "https://drive.google.com/uc?export=download&id=1gGuyEEJasHylGFcrgYBBSD3VLoemYR4K",
            "https://drive.google.com/uc?export=download&id=1WSMjvCfpHB2SVWSwhF_u9PLyed4uLmP-",
            "https://drive.google.com/uc?export=download&id=16bPgPRRVATgIKLoW59u49Tfs_qnFJQhV"
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
                        if(it.bookName.lowercase().contains(search)){
                            filter.add(it)
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

    override fun onClick(item: Books) {
        val intent = Intent(context,Downloader::class.java)
        intent.putExtra("title",item.bookName)
        intent.putExtra("link",item.link)
        startActivity(intent)
    }
}