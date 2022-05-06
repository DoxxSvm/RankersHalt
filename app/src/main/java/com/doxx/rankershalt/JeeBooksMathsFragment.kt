package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeBooksMathsFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant Differential Calculus",
            "Arihant Integral Calculus",
            "Arihant Play With Graphs",
            "Arihant Trigonometry",
            "Arihant Vector and 3D Geometry",
            "Arihant Algebra",
            "Arihant Coordinate Geometry"
        )
        links= arrayOf(
            "https://drive.google.com/uc?id=1-9Ot9890laYQJG6XKncWC4WTY4yGwnQN&export=download",
            "https://drive.google.com/uc?id=1KH4dgVnkrOz1achVss296hHdvZ_uZ7ly&export=download",
            "https://drive.google.com/uc?id=1j2gZlEkFCDWgXrZpeAdaTRuT8tY46jO-&export=download",
            "https://drive.google.com/uc?id=1tv7VrsgUq-yuZBYh6DTR64fL1JecsW8j&export=download",
            "https://drive.google.com/uc?id=1-LzmV3h_qhkQ6P9zclEX8q70pPIlOyPU&export=download",
            "https://drive.google.com/uc?id=1Gl8kR5R8i_XGXoFECYRxc3W_vf75AD9H&export=download",
            "https://drive.google.com/uc?id=1nIru58DaeM1F5Xwsp64k80h58HWK3nlO&export=download"
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