package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class VitPyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "VITEEE 2018 Question Paper with Solution",
            "VITEEE 2017 Question Paper with Solution",
            "VITEEE 2016 Question Paper with Solution",
            "VITEEE 2015 Question Paper with Solution",
            "VITEEE 2014 Question Paper with Solution",
            "VITEEE 2013 Question Paper with Solution",
            "VITEEE 2012 Question Paper with Solution",
            "VITEEE 2011 Question Paper with Solution",
            "VITEEE 2010 Question Paper with Solution",
            "VITEEE 2009 Question Paper with Solution",
            "VITEEE 2008 Question Paper with Solution",
            "VITEEE 2007 Question Paper with Solution",
            "VITEEE 2006 Question Paper with Solution"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1s1EdHilqSv7DjPUBwif1fHM3tXbm0-Dw",
            "https://drive.google.com/uc?export=download&id=1Nl6WxRqRA4oBXlefM8FhYRG5rN5Hbq6Y",
            "https://drive.google.com/uc?export=download&id=1bHG4FVORQAs3tXZPd23d5hAr3MNU0Kvl",
            "https://drive.google.com/uc?export=download&id=1k-26trQQqOV97Wn8B-YLgapnnRjjIdV2",
            "https://drive.google.com/uc?export=download&id=1FzYV06DchOLZAL92Y5kf--d_Vj7YvE4g",
            "https://drive.google.com/uc?export=download&id=1XQIFIYJsIa7-VzBPBCJoQyhTP4R2so9B",
            "https://drive.google.com/uc?export=download&id=1hqfZ6TvJMDM1zTlJAGmsaCfmxq833wlz",
            "https://drive.google.com/uc?export=download&id=10XzaU6Nic6lZA-xAsj4DuL3IFTahWaD3",
            "https://drive.google.com/uc?export=download&id=1zZkIY3HkmzaVruRLKFwfSEbD1HmSPaxd",
            "https://drive.google.com/uc?export=download&id=166qAR5tA0BZtfSHCBg33Yt4vuwgBhQaA",
            "https://drive.google.com/uc?export=download&id=1dyWYK_LrfwZpAKtz1NGrSqjWkTenc9V4",
            "https://drive.google.com/uc?export=download&id=1VG34fi70kTyELBCTmYjTk2SvAE0dDwcK",
            "https://drive.google.com/uc?export=download&id=1a8QEA_fn3E8FsHpkFplTMGF0KKmRMrUI"
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