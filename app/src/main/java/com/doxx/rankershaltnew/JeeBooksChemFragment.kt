package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeBooksChemFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant Chemistry 41 Years JEE Main and Advanced",
            "Advanced Problems in Organic Chemistry - MS Chouhan",
            "Balaji Problems in Inorganic Chemistry - VK Jaiswal",
            "Physical Chemistry - N Awasthi",
            "Organic Chemistry important reagents",
            "Solomons Fryhle Organic Chemistry by Ms Chouhan",
            "Arihant Master the NCERT Chemistry Class 11 Part 1",
            "Arihant Master the NCERT Chemistry Class 11 Part 2",
            "Arihant Master the NCERT Chemistry Class 12 Part 1",
            "Arihant Master the NCERT Chemistry Class 12 Part 2",
            "Physical Chemistry - OP Tandon",
            "Inorganic Chemistry - OP Tandon",
            "Organic Chemistry - OP Tandon",
            "NCERT Chemistry class 11 part 1",
            "NCERT Chemistry class 11 part 2",
            "NCERT Chemistry class 12 part 1",
            "NCERT Chemistry class 12 part 2",
            "NCERT Exemplar Class 11 Chemistry",
            "NCERT Exemplar Class 12 Chemistry",
            "Physical Chemistry - J Ross",
            "Physical Chemistry - P Bahadur",
            "Pradeep Chemistry Class 11",
            "MTG NCERT Fingertips Chemistry Class 11 & 12",
            "JD LEE Concise Inorganic Chemistry Sudharshan Guha",
            "Problem and Solutions in Inorganic Chemistry (Chapter 01 - 04)",
            "Problem and Solutions in Inorganic Chemistry (Chapter 05 - 12)"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1vXBaBzDWOlHIXywNXQXtD-TFkjTyj_JP",
            "https://drive.google.com/uc?export=download&id=1W5Aeup9wXnIGBX0Pfrk0Bj5uLBts7iXG",
            "https://drive.google.com/uc?export=download&id=1bbH6J7OgcirFLJ7komDs6VDM1UGtRFDo",
            "https://drive.google.com/uc?export=download&id=1bdhAyzhBs1A4b3yMVk6EYpa6u4hk-RkH",
            "https://drive.google.com/uc?export=download&id=1VjlJifImLccDLbq7RgSF29TeHlbMQnpx",
            "https://drive.google.com/uc?export=download&id=1BS68i0jahjVcZvhVT5Ymhra06Z6MYx-a",
            "https://drive.google.com/uc?export=download&id=1mONWCwZPmtUdBqGNQx08aVIYUSnPQUU0",
            "https://drive.google.com/uc?export=download&id=1jm04ionxVfJm9CdRpptCF5BDhWlB1jv-",
            "https://drive.google.com/uc?export=download&id=13g0eg810qYGsJRTGjjhzSCxurGnspH0B",
            "https://drive.google.com/uc?export=download&id=1KJIwVg5D2TTNSxK0yiFyUkz2TKceOg-5",
            "https://drive.google.com/uc?export=download&id=1BTkowg7qE9llipPjzmAVM6sroZa5DHNe",
            "https://drive.google.com/uc?export=download&id=1wrWs4Et-FLEj82IVCnUfAEmUwKPmNnkr",
            "https://drive.google.com/uc?export=download&id=1qP8yaz0BpnG4ORMIJALmfOt37Ozfh-Iq",
            "https://drive.google.com/uc?export=download&id=10krIiBi_VZaex2j06MxiWT4SWIFnbAIk",
            "https://drive.google.com/uc?export=download&id=1-CzQER1XqZFbkv1izKIK8njWg0g_WYDU",
            "https://drive.google.com/uc?export=download&id=1zrSXrwLS-HZLE6qSuGKAkd7pBSy0Z4RK",
            "https://drive.google.com/uc?export=download&id=1zxtV4AlTZ9iVVccVbbqL9eRWHjE7YvqU",
            "https://drive.google.com/uc?export=download&id=1WBv1WFRXLYKlCar7hXRvodhz_4YYanK9",
            "https://drive.google.com/uc?export=download&id=1sJKzimYQDAbmOFcHD5EkPKtHkepSuBrZ",
            "https://drive.google.com/uc?export=download&id=1-KBFwG1PpblSba5x0bUCF75UGvQyFMlo",
            "https://drive.google.com/uc?export=download&id=1-ZO6iFf9StmMEjRpAVwthiQ81y3POlAK",
            "https://drive.google.com/uc?export=download&id=1077MDdYX3I144dG-_6ybPzOc6uiuL51H",
            "https://drive.google.com/uc?export=download&id=10EAgZf0VBYO_ck8yVNtcZJrRlVmthGEL",
            "https://drive.google.com/uc?export=download&id=10BN-2AdJUwEBicdGCJGEqNyspeCcRqfv",
            "https://drive.google.com/uc?export=download&id=1-8kNlg-gDA6DKOya5ClsdB1JmNljDUDB",
            "https://drive.google.com/uc?export=download&id=1-9LWigd9PuwBMKyf_HWN2FC5lUID4iWb"

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