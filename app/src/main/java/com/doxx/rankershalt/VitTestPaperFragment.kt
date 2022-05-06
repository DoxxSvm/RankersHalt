package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class VitTestPaperFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "VITEEE Test Paper 01 with Solution",
            "VITEEE Test Paper 02 with Solution",
            "VITEEE Test Paper 03 with Solution",
            "VITEEE Test Paper 04 with Solution",
            "VITEEE Test Paper 05 with Solution",
            "VITEEE Test Paper 06 with Solution",
            "VITEEE Test Paper 07 with Solution",
            "VITEEE Test Paper 08 with Solution",
            "VITEEE Test Paper 09 with Solution",
            "VITEEE Test Paper 10 with Solution"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1rdtz6P5ovHvFg_RM_5gTnKzz00HZ3b_R",
            "https://drive.google.com/uc?export=download&id=1nBb9L2OmPPIPXkoCAk8c_40JE310vqLL",
            "https://drive.google.com/uc?export=download&id=1OPgF9_CwoPTJKfRJoeqWJgeaKCHqpK3M",
            "https://drive.google.com/uc?export=download&id=1mJlVMaFziwrgV8wpeVjFf12O1pwVV7Pd",
            "https://drive.google.com/uc?export=download&id=13Er4Y3tWNfw0sKipLRs6QIiDSwZUX8km",
            "https://drive.google.com/uc?export=download&id=1jAhycxWVaqoZO5m5YY0siIYIxN_HGjq2",
            "https://drive.google.com/uc?export=download&id=1j7zXvUWVyMZuS_lomInOv8uf5DRE3yok",
            "https://drive.google.com/uc?export=download&id=1u0Ukb138gxuIfIGgAki0s_-s2FmsRvgb",
            "https://drive.google.com/uc?export=download&id=1FqwLAKhlb0BOoevMjnXOHeR4F58e6tLt",
            "https://drive.google.com/uc?export=download&id=1TxuPdPJHVlCsPjCBxfpCVpuxqpTRPM69"
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