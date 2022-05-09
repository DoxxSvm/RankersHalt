package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetBooksBioFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant Master The NCERT Biology Vol.1",
            "Arihant Master The NCERT Biology Vol.2",
            "33 Years NEET Solved Paper - Biology",
            "NCERT Biology class 11",
            "NCERT Biology Class 12 Chapter 01-02",
            "NCERT Biology Class 12 Chapter 03-08",
            "NCERT Biology Class 12 Chapter 09-16",
            "Biology Revision Notes - 11th",
            "Biology Revision Notes - 12th",
        )
        links= arrayOf(
            "https://drive.google.com/uc?id=1M2DuC7h5_UobWyk-1IuL0aSB80sbfMpP&export=download",
            "https://drive.google.com/uc?id=15b88baAXSYhGzIij76H2iYZa7m5yYDy0&export=download",
            "https://drive.google.com/uc?export=download&id=1zY95L_9S60toOfgl77eXMhpQpgt1Qo7c",
            "https://drive.google.com/uc?export=download&id=113CBHltDyvYwPzBAIU5ZNudp33gZd713",
            "https://drive.google.com/uc?export=download&id=1qnopWI6wKgWh7zeArrSibiZcqfws_J-3",
            "https://drive.google.com/uc?export=download&id=1ckJzbnDvuQuBYuHT_5Z1bS5XfHPf7uqj",
            "https://drive.google.com/uc?export=download&id=1LV2StDl-GPUvOcXZhWCUSl9n6BUWrDNo",
            "https://drive.google.com/uc?export=download&id=10UM2Go83tqjIdasZnDzWCW0H4Fn6-SQZ",
            "https://drive.google.com/uc?export=download&id=10acUytyufxoq4TvuNcurWvkBTm75yoPK",
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