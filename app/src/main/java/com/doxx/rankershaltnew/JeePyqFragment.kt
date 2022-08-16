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
            "https://drive.google.com/uc?export=download&id=1MLZ481oJCqyy3oG2EJayQJON5CH-kVF1",
            "https://drive.google.com/uc?export=download&id=1KbwPOAZUJKNhGbDbULtfigLjZZkLJs1b",
            "https://drive.google.com/uc?export=download&id=1L3rDGT74qNH-wNEcjTxVj1Fkk5WlFTbU",
            "https://drive.google.com/uc?export=download&id=1fsZHOrFkww7zzwc5RM5V9idFWzqS_T9R",
            "https://drive.google.com/uc?export=download&id=1o8aCgJ4ZVu37ZjkZrp7onBDsl21nPFPP",
            "https://drive.google.com/uc?export=download&id=1hgVKk7KHaaeUfxk-CyRpF3vqcQymMhvT",
            "https://drive.google.com/uc?export=download&id=1jJsOz0Qj4Pr8h5aCKJqrjUDbEhm1p8IT",
            "https://drive.google.com/uc?export=download&id=1FFO95a_EI7WNOT24PgZCJWin_1JbBG-3",
            "https://drive.google.com/uc?export=download&id=1Z8Yk3_E3AwmC1TFD-Jbx4TtAsVeHWuDl",
            "https://drive.google.com/uc?export=download&id=1Iba17bhc8URiS4RCAleAPFTsiql4NZ_t",
            "https://drive.google.com/uc?export=download&id=1Y3d3omLJFR8fjge5thSYaqEx2_PFNQ9A",
            "https://drive.google.com/uc?export=download&id=1vFxI6CCjMW_pcCEqdkzZXAhe6109Ma0Q",
            "https://drive.google.com/uc?export=download&id=1SoIRGg6sK5hcu0sAFtZ9ikzRYQCqKiur",
            "https://drive.google.com/uc?export=download&id=1sBsevlUWyOOacQ8THF_HO7rU-W_fi03g",
            "https://drive.google.com/uc?export=download&id=1SOjMUi476CuSWvpAcWyy1sPyVhKRSBzh",
            "https://drive.google.com/uc?export=download&id=1FCaPcJgsPqJjLPP_NP0ATFz88oZOwGLs",
            "https://drive.google.com/uc?export=download&id=1_fWySjrxHtD-uYwdh1iLdgE93-uzOwUv",
            "https://drive.google.com/uc?export=download&id=1rFitbirDZXtD56R7sLHkZRRDCoAuAUC9",
            "https://drive.google.com/uc?export=download&id=15GoPYdG4wdz19wZlPsefvTnM7dfRMAk6",
            "https://drive.google.com/uc?export=download&id=1kV0TjsZS3nURCr3IqqaYyCJW46LtDg4g",
            "https://drive.google.com/uc?export=download&id=1reDxr6eHFlivUK5kRMmEpZ2acDTBmdZs",
            "https://drive.google.com/uc?export=download&id=1ZwLeWqtQ1TfIIJU4dHEnUJV3b6f2w_pN",
            "https://drive.google.com/uc?export=download&id=1VRXV6StZ3xeZ3pA32z0DQdsbwGBaruok",
            "https://drive.google.com/uc?export=download&id=1Hw0ZCOHlIK61urdV8vMeaxtp50ekLrz8",
            "https://drive.google.com/uc?export=download&id=1q9UnwLkTolo8s6g3hq0sf2tb8A9LyYoQ",
            "https://drive.google.com/uc?export=download&id=1EjFdXzwzYH2ZqPMd_tb1Ncagr9G4IK8C",
            "https://drive.google.com/uc?export=download&id=1ZIwpOJKzFmOsmQSvstDO3WFrficICw8g",
            "https://drive.google.com/uc?export=download&id=1o4tqVB0yz6uipxTRza18060bmwBS_IGx",
            "https://drive.google.com/uc?export=download&id=1_N9BM2NogRLHtdlElx_5HdjdQFugSyF6",
            "https://drive.google.com/uc?export=download&id=11n6yWQZZ6p8NZOeG-DTLZ5wK8m6EjUA-",
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