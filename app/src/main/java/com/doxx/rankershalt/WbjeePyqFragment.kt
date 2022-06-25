package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class WbjeePyqFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "WBJEE 2021 Question Paper with Solution",
            "WBJEE 2020 Question Paper with Solution",
            "WBJEE 2019 Question Paper with Solution",
            "WBJEE 2018 Question Paper with Solution",
            "WBJEE 2017 Question Paper with Solution",
            "WBJEE 2016 Question Paper with Solution",
            "WBJEE 2015 Question Paper with Solution",
            "WBJEE 2014 Question Paper with Solution",
            "WBJEE 2013 Question Paper with Solution",
            "WBJEE 2012 Question Paper with Solution"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1msnK6KZo8yYV3qXSrDMY0368vS_GAMcS",
            "https://drive.google.com/uc?export=download&id=1iwsbEudHfKgcR_jAk_jY5dUYVWiItMfq",
            "https://drive.google.com/uc?export=download&id=1uUG8K9WKUkIOQmKdj4Rr9l_M8Lg2ie1T",
            "https://drive.google.com/uc?export=download&id=1Knj8ZRlsUSn421eda1ZiRPWZyZ6sWz9c",
            "https://drive.google.com/uc?export=download&id=1oLIo3FG0J_m7j4H3Gxev_-_K-04I2Pin",
            "https://drive.google.com/uc?export=download&id=1_Kw5g3IMmsTDQqD94M-w_WVPmd72vhrn",
            "https://drive.google.com/uc?export=download&id=1TFV0fNzBzLueZoUPeSt6D5TGLeHFCVdE",
            "https://drive.google.com/uc?export=download&id=10yBzoKVbjsrMdqUWYQAC5J4ACmH_JODx",
            "https://drive.google.com/uc?export=download&id=1FUfO-iK3sxjSo92UnkVSXzhJrwjQzUCs",
            "https://drive.google.com/uc?export=download&id=1rOgP8iXLa7iz9Ac6WWMd6kdDfM8POZEf"
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