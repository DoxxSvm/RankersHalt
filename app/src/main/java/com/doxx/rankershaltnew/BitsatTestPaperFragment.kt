package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class BitsatTestPaperFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "BITSAT Test Paper 01",
            "BITSAT Test Paper 02",
            "BITSAT Test Paper 03",
            "BITSAT Test Paper 04",
            "BITSAT Test Paper 05",
            "BITSAT Test Paper 06",
            "BITSAT Test Paper 07",
            "BITSAT Test Paper 08",
            "BITSAT Test Paper 09",
            "BITSAT Test Paper 10",
            "BITSAT Test Paper 11",
            "BITSAT Test Paper 12",
            "BITSAT Test Paper 13",
            "BITSAT Test Paper 14",
            "BITSAT Test Paper 15",
            "BITSAT Test Paper 16",
            "BITSAT Test Paper 17"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1AKTDcAvJIGpvPaR0LKINtSt7qVz-N_Mk",
            "https://drive.google.com/uc?export=download&id=1DH_LWI8YXaybG0z-5dfpLoOVgJfBZycX",
            "https://drive.google.com/uc?export=download&id=1Nt9AiWxUUm7CGGOAwJRgOiD8JGMP0zV_",
            "https://drive.google.com/uc?export=download&id=1xBqSRoxPG-N8rxnMiy9kWXXn0aRAnc1m",
            "https://drive.google.com/uc?export=download&id=1ohy1-tj3wG7sVog2VXhJGRP2AZIjAeoe",
            "https://drive.google.com/uc?export=download&id=1N_weSrPwC3rAfNg8zjv3crdhNhAAwnJC",
            "https://drive.google.com/uc?export=download&id=1ySBZZ4N_Smu0QMIhgMI7voSxMnwy9ldJ",
            "https://drive.google.com/uc?export=download&id=1hZX-ieZbhPdfuPZilrMB6O-o3VIsVuju",
            "https://drive.google.com/uc?export=download&id=18kwTEEFoa-yD7FvoJd5RJMhE53LtDC8-",
            "https://drive.google.com/uc?export=download&id=13hKUqTkGsBHTrSeEZWvmwyoRbUV5UQgz",
            "https://drive.google.com/uc?export=download&id=18lh_D56RsKfdnwde4n3H0CA2TK15HsxZ",
            "https://drive.google.com/uc?export=download&id=1n6LEyRRqNpL8hCTKJUnfp9Z9jYQmVKWi",
            "https://drive.google.com/uc?export=download&id=16jwTujJw3kJZsuhoryWtTWTSUwopXi8c",
            "https://drive.google.com/uc?export=download&id=1ARQ-C2ZaxBZ7ZsTvOfYpPGBo429fMUjB",
            "https://drive.google.com/uc?export=download&id=18vyhTM1_oI21WV2ZOaXP9kOYXXHYNBfY",
            "https://drive.google.com/uc?export=download&id=1IaQs0shDsIu_W9nIBoghwhdoHocmQvau",
            "https://drive.google.com/uc?export=download&id=1w-xcNKMqxXaF6vAI37zDxJHVTotEGLkG"
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