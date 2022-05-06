package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class CrashCourseFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant JEE Main CHEMISTRY 40 Days Crash Course",
            "Arihant JEE Main MATHEMATICS 40 Days Crash Course",
            "Arihant JEE Main PHYSICS 40 Days Crash Course",
            "Arihant NEET BIOLOGY 40 Days Crash Course",
            "Arihant NEET CHEMISTRY 40 Days Crash Course",
            "Arihant NEET PHYSICS 40 Days Crash Course"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1jpL4NK1QmPUX7EjahmNafSsryfhkgpR9",
            "https://drive.google.com/uc?export=download&id=1APOK0W5A_vrE3IkEGQLK3lKPYQdEmkF-",
            "https://drive.google.com/uc?export=download&id=1AUasDHgcKe2D4GMAcVKmK0H0yLLbQ9e9",
            "https://drive.google.com/uc?export=download&id=1LcYXWnaMTffvOpmk9RjaLb8sK_9rtez7",
            "https://drive.google.com/uc?export=download&id=1JVLW6NjstezkDgbmUdv0OGLfghC9-qyf",
            "https://drive.google.com/uc?export=download&id=1Rt538bAD8ORODX3rtX7UsbsX3hWwjA9X"
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