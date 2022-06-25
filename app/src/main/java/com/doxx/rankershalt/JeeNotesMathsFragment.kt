package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeNotesMathsFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "AOD, Area, Definite and Indefinite Integration",
            "Combinatorics and Binomial Theorem",
            "Coordinate Geometry",
            "Limits, Continuity, Differentiability and Differential Equations",
            "Matrices and Determinants",
            "Probability and Statistics",
            "Quadratic Equations and Complex Number",
            "Sequence and Series",
            "Set Theory and Functions",
            "Trigonometry and Inverse Trigonometric Functions",
            "Vector and 3d Geometry"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1-MgzAMAdbSjiBdMn_JlElioXonq1FDNx",
            "https://drive.google.com/uc?export=download&id=1LBml1FPjk1XozNW0yQbKslnqPdEF5xjp",
            "https://drive.google.com/uc?export=download&id=1IzfEcbDgjpZNHVLXqMYdEUvZESwzZrQs",
            "https://drive.google.com/uc?export=download&id=17XFXacV1rql7tAqP2hI5vAQxqB51bO3D",
            "https://drive.google.com/uc?export=download&id=1-Hbg_LmEjDftaqp1q7KV-Juxc5RdbMdg",
            "https://drive.google.com/uc?export=download&id=1C2eJb9-A5cVR7NqXytPVBLzPBndp6Ykp",
            "https://drive.google.com/uc?export=download&id=1cUVmOc-eBxOdIaWyKvGZeKhDE15BchGk",
            "https://drive.google.com/uc?export=download&id=1tB9LkobykI-RlHGSsnV7rAuzoosmmXwe",
            "https://drive.google.com/uc?export=download&id=14PS84Y0lMFMSR7VyIpnCjR6RmXkGCc_s",
            "https://drive.google.com/uc?export=download&id=1sRXb2SIMwKsBk1To5W9hGpS7MmeGyWhC",
            "https://drive.google.com/uc?export=download&id=1lqSCMBBsfVwcb6OeyoyxCUrs6BTsBnXd"
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