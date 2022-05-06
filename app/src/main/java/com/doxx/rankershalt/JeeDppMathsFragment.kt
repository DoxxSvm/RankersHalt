package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeDppMathsFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

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
            "Differential equations Vector DPP",
            "algebra DPP",
            "3-D Geometry DPP",
            "Linear programming DPP",
            "Probability DPP",
            "Sets DPP",
            "Relations and Functions DPP",
            "Trigonometric Functions DPP",
            "Principle of Mathametical Induction DPP",
            "Complex Numbers and Quadratic Equation DPP",
            "Linear Inequalities DPP",
            "Permutations and Combiantion DPP",
            "Binomial Theorem DPP",
            "Sequence and Series DPP",
            "Straight Lines and Pair of Straight Lines DPP",
            "Conic Section DPP",
            "Limits and Derivatives DPP",
            "Mathematical Reasoning DPP",
            "Statistics DPP",
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
            "https://drive.google.com/uc?export=download&id=1vQxaEnejl72mcnOA9j_Usg9SKnj7Ovcm",
            "https://drive.google.com/uc?export=download&id=19a7DempPM-bcPLRTy3dSouHzw8hE0_-k",
            "https://drive.google.com/uc?export=download&id=1dsRa3l-jZjbjcSBellpLQpL2xF5890cV",
            "https://drive.google.com/uc?export=download&id=1nEhW2s7jJNTSAOhIZ1jqyg9oDkRNPQ9o",
            "https://drive.google.com/uc?export=download&id=1Rya16uUbCboC7aYbNRlPaGm-f_A3pKFh",
            "https://drive.google.com/uc?export=download&id=19Zp7zbZbZ8aTKb9kYvzcCgpDYnDmapqa",
            "https://drive.google.com/uc?export=download&id=1iJfHN_U1dTLkZjpLoAPkZpXZKrDhYzQz",
            "https://drive.google.com/uc?export=download&id=1PfYqPQHHF2E8h8ddsvkIeNBlIz580oxM",
            "https://drive.google.com/uc?export=download&id=1fAHPSEPdK809NZDoKT9Iv6T9HzYScuYk",
            "https://drive.google.com/uc?export=download&id=1v-JtSSXAZqCB3UatEm5t0KvbOw5A8r9I",
            "https://drive.google.com/uc?export=download&id=1jo55bxJMRuEUz1cJxHJMLu85SyxbZPok",
            "https://drive.google.com/uc?export=download&id=1FMHxQKbauQgu93MF50jE--LRtz_vdlan",
            "https://drive.google.com/uc?export=download&id=1ImHbjgp1OpDqLMi7QdN91mPeXvk3KvrZ",
            "https://drive.google.com/uc?export=download&id=1aNeMHrdQqTXGMbBlKlsr_D2DqfxQkang",
            "https://drive.google.com/uc?export=download&id=1J_dc4JIjtZRGoyGQlLqZKd4rq7hpURlv",
            "https://drive.google.com/uc?export=download&id=1dADRjt7O9NnSh1zJngdNd76RU-v4VICx"


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

    override fun onClick(item: Books) {

        val intent = Intent(context,Downloader::class.java)
        intent.putExtra("title",item.bookName)
        intent.putExtra("link",item.link)
        startActivity(intent)


    }
}