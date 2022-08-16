package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class RevisionFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Biology Revision Notes - 11th",
            "Biology Revision Notes - 12th",
            "Inorganic Revision Notes",
            "Maths Revision Notes",
            "Physical and organic Revision Notes",
            "Physics Revision Notes",
            "Disha Handbook for Revision"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=10UM2Go83tqjIdasZnDzWCW0H4Fn6-SQZ",
            "https://drive.google.com/uc?export=download&id=10acUytyufxoq4TvuNcurWvkBTm75yoPK",
            "https://drive.google.com/uc?export=download&id=1zkz2IqJ3xQtj4Aj3VGrqP9w9gC6n8LSw",
            "https://drive.google.com/uc?export=download&id=1zgHmwPWVCR6uE_JpcxqQ3dCP5fJ7jWPi",
            "https://drive.google.com/uc?export=download&id=1zjek66j53j55glUW-IUAvivcdQhMQRfU",
            "https://drive.google.com/uc?export=download&id=1zgdSkIYuE88cRHeCEr3GxhGjjKZKdZMT",
            "https://drive.google.com/uc?export=download&id=17LvsZSSPZwq1-N74pEAekWqLcpOGERrM",

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