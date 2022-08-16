package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetPyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "NEET 2021 Question Paper with Solution",
            "NEET 2020 Question Paper with Solution",
            "NEET 2019 Question Paper with Solution",
            "NEET 2018 Question Paper with Solution",
            "NEET 2017 Question Paper with Solution",
            "NEET 2016 Question Paper with Solution",
            "NEET (AIPMT) 2016 Question Paper with Solution",
            "NEET 2015 Question Paper with Solution",
            "NEET (AIPMT) 2015 Question Paper with Solution",
            "NEET (AIPMT) 2014 Question Paper with Solution",
            "NEET (AIPMT) 2013 Question Paper with Solution"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1CctRbxmcXin3THDqJNuZkJhO9OoWK2B0",
            "https://drive.google.com/uc?export=download&id=1rYZhlPnYawfSa_anT9Y_FDa0XHzz0JAW",
            "https://drive.google.com/uc?export=download&id=17j2RsQa_LVQ30dv9WSIo55wqGOT799un",
            "https://drive.google.com/uc?export=download&id=1sK2svJV8kJOxkEmyfUd0WN3Leds8U2GV",
            "https://drive.google.com/uc?export=download&id=1cW46EYu8gKYU1qXrTolzrxOCrY2CPHYN",
            "https://drive.google.com/uc?export=download&id=1NywAAZqfujScZBqhiPe4-gfNC7GXvkKU",
            "https://drive.google.com/uc?export=download&id=1-YSNgY6PjMGEtqThFXHBWoG2ADQXes0U",
            "https://drive.google.com/uc?export=download&id=1hkJ06hTBrgADIvg6d7cSNM9QQP1AV24a",
            "https://drive.google.com/uc?export=download&id=1suEXOqdWXi0TheoiQAX1Pf6SApk-W4CA",
            "https://drive.google.com/uc?export=download&id=1idqr5qa9E7bJSW9nePsd2oxfSziSyNpV",
            "https://drive.google.com/uc?export=download&id=1h8MYFHSFGtYJuG7qyxrK0NtdmLjh8cSj"
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