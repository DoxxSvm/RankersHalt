package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NcertBioFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Biotechnology and It's principle NCERT Highlighted",
            "Biotechnology Principal and Process NCERT Highlighted",
            "Ecosystem NCERT Highlighted",
            "Environmental Issue NCERT Highlighted",
            "Evolution NCERT Highlighted",
            "Human Reproduction NCERT Highlighted",
            "Microbes in Human NCERT Highlighted",
            "Moleculat Basis in Inheritance NCERT Highlighted",
            "Principle of Inheritance and Variations NCERT Highlighted",
            "Reproduction in Organisation NCERT Highlighted",
            "Reproductive Health NCERT Highlighted",
            "Sexual Reproduction in Flowering Plants NCERT Highlighted"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1_92mrF3lzReS4FLuD9h2mRYuOp9MtrRl",
            "https://drive.google.com/uc?export=download&id=11tDIONENEwYM3JcFG8pExqQAq03UVXjh",
            "https://drive.google.com/uc?export=download&id=1QuioV-_T66fYJl_YzIhihWfthognQaLy",
            "https://drive.google.com/uc?export=download&id=16RBp1-54UvDRrhRSQeiVyOkZIXAEWkJ2",
            "https://drive.google.com/uc?export=download&id=1wA8Iy_xTEScTTfILRSiImRx62tdb3GpI",
            "https://drive.google.com/uc?export=download&id=1E5_ibK6pStrJSl8TFDkLCGvaJUwR4HWj",
            "https://drive.google.com/uc?export=download&id=16EA9XS3u0OXnWsbKzJJG9GF5xhlpSgFN",
            "https://drive.google.com/uc?export=download&id=1WxA3lHmcL1fuHukHnvUXbSex1cI0J00l",
            "https://drive.google.com/uc?export=download&id=1TZ9WI6UZkfIvwEmJBaKCvOaIXTVxtuAx",
            "https://drive.google.com/uc?export=download&id=1cLht8BnyP0_B89OzTG6r9y1TSrPp6CBz",
            "https://drive.google.com/uc?export=download&id=1PqfUg9qP22TsGRal5lXt3sQM_Y1IqY7P",
            "https://drive.google.com/uc?export=download&id=1CbPZWXkvISTbUhwwZKRyA_fzxw_SSIsg"

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