package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetTestPaperFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "NEET Test Paper 01 (New Pattern)",
            "NEET Test Paper 02 (New Pattern)",
            "NEET Test Paper 03 (New Pattern)",
            "NEET Test Paper 04 (New Pattern)",
            "NEET Test Paper 05 (New Pattern)",
            "NEET Test Paper 06 (New Pattern)",
            "NEET Test Paper 07 (New Pattern)",
            "NEET Test Paper 08 (New Pattern)",
            "NEET Test Paper 09 (New Pattern)",
            "NEET Test Paper 10 (New Pattern)",
            "NEET Test Paper 11",
            "NEET Test Paper 12",
            "NEET Test Paper 13",
            "NEET Test Paper 14",
            "NEET Test Paper 15",
            "NEET Test Paper 16",
            "NEET Test Paper 17",
            "NEET Test Paper 18",
            "NEET Test Paper 19",
            "NEET Test Paper 20"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1C2DbH9R-HPHWPHfgBGepRy8KoWKUpRnH",
            "https://drive.google.com/uc?export=download&id=1OcD_OD3woPXXCPp3MKPyI-246IrygJQE",
            "https://drive.google.com/uc?export=download&id=1NtA-6paky6AjItEfEnPtHcoKNYp4nsrl",
            "https://drive.google.com/uc?export=download&id=1xT3kFwMYNYwmxzaZIYYrHWUWxGIbh7oJ",
            "https://drive.google.com/uc?export=download&id=1uD4OYzn3zlQ8JL4lpHAQgyfHErlW3pif",
            "https://drive.google.com/uc?export=download&id=1bHwUe7QQ-l2UyaVhf4pegXwrOcVCC0it",
            "https://drive.google.com/uc?export=download&id=1YlKNacYVh1w2XAFJv2sPGGgQKhxNqeg8",
            "https://drive.google.com/uc?export=download&id=1yWowJNyDl5wL2S6kHaczdzxk5RPV2p63",
            "https://drive.google.com/uc?export=download&id=1pgoQFFeS3Uzf2QnZkP_EFr-BACkOJqSY",
            "https://drive.google.com/uc?export=download&id=1QgOvGIUrOGncvBAZNUDBnAMA2HJAkUTQ",
            "https://drive.google.com/uc?export=download&id=1l_st_m5h6DN8hQZEBSQIjBc8Z2SxlaoP",
            "https://drive.google.com/uc?export=download&id=1GknB-7X6SoNK31uRwmmZpOnUSVGDtVRK",
            "https://drive.google.com/uc?export=download&id=1Czwy2vP8Peny73g3eZMN0rED8S-UobZx",
            "https://drive.google.com/uc?export=download&id=1VuH3NLsLEErPuUoTu0oJng0SjEUdjmz5",
            "https://drive.google.com/uc?export=download&id=16Oc2Fry_X3OTcUmZ2RdKXsqUfo5QBgeC",
            "https://drive.google.com/uc?export=download&id=12NCN0Um2Mjh5ZgbqW5mK0CeTaOc87C3u",
            "https://drive.google.com/uc?export=download&id=1kb_Wfe7UyQXY04zJzppqW_R6qB04J-Ui",
            "https://drive.google.com/uc?export=download&id=1U6VUdAL6pEwN5LdugXl8WtXvPogKA8KI",
            "https://drive.google.com/uc?export=download&id=1gfzL-xsMYYlDZvFAjIiH7gKpXm2rIkwM",
            "https://drive.google.com/uc?export=download&id=1lAc98AKkGTnuCN8MAzK9TpjC6DJetjCs"
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