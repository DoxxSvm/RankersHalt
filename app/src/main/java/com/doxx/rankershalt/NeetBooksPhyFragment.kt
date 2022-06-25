package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetBooksPhyFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "33 Years NEET Solved Paper - Physics",
            "MTG NCERT Fingertips Physics Class 11",
            "MTG NCERT Fingertips Physics Class 12",
            "Arihant Master the NCERT Physics Class 11 Part 1",
            "Arihant Master the NCERT Physics Class 11 Part 2",
            "Arihant Master the NCERT Physics Class 12 Part 1",
            "Arihant Master the NCERT Physics Class 12 Part 2",
            "DC Pandey Electricity and Magnetism",
            "DC Pandey Mechanics Volume 1",
            "DC Pandey Mechanics Volume 2",
            "DC Pandey Optics And Modern Physics",
            "DC Pandey Waves And Thermodynamics",
            "HC Verma Concept of Physics Volume 1",
            "HC Verma Concept of Physics Volume 2",
            "HC Verma Concept of Physics Solutions Volume 1",
            "HC Verma Concept of Physics Solutions Volume 2",
            "NCERT Exemplar Class 11 Physics",
            "NCERT Exemplar Class 12 Physics",

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1dhmY5YBLAcxuoJGEYDxkY-vi1TaiMCTJ",
            "https://drive.google.com/uc?export=download&id=1-Xyal7dxwbcqPVDUyHMNM76YdZ-QzjYL",
            "https://drive.google.com/uc?export=download&id=1-VqMluP5OhRbaxb79V_9jN8BZhqWLsQN",
            "https://drive.google.com/uc?export=download&id=1UJry_BCKp4mLqWrrIlpDPnKjlJWYZLN7",
            "https://drive.google.com/uc?export=download&id=18yZnYd-w3fiKNm7dJwiSOCX4ftjb1q4x",
            "https://drive.google.com/uc?export=download&id=1RhqqJWygEW-Az2-kbeyc6MUKyK9HQ3R4",
            "https://drive.google.com/uc?export=download&id=1VEkDzTF5WpMBxaAletaR9VI-m9R2B1rA",
            "https://drive.google.com/uc?export=download&id=19j3RXKKL4g4gp7fkGID3uufyqq0vHJrM",
            "https://drive.google.com/uc?export=download&id=1olzusP6d8uib5jYvQBoGO2SV4YMiwrzX",
            "https://drive.google.com/uc?export=download&id=1NB1pi33_QrZHxLuNmvos59Nu7p3gfNCV",
            "https://drive.google.com/uc?export=download&id=13gWmgB9uxVfWkyvOLdKk9NcvcAlsC_J7",
            "https://drive.google.com/uc?export=download&id=1WmJC1DCyJFxaTHhwZO5aAKoNisX3XUwx",
            "https://drive.google.com/uc?export=download&id=1kZHkkzAbeofxsn_gkh_0Gprvc4jnCuoZ",
            "https://drive.google.com/uc?export=download&id=1UVmhHW2MWgwoYDG6gFE-KQYVcE3Ki3q_",
            "https://drive.google.com/uc?export=download&id=1b5ZWp1vMlgScrb3YY2T-tHBLdl9QFupC",
            "https://drive.google.com/uc?export=download&id=1-PCmB2Q60wYrUvDHsO7b3ShGT46wyiKY",
            "https://drive.google.com/uc?export=download&id=101MpMOfEnU_HmTJZkvQ8G3sioBKqoAlA",
            "https://drive.google.com/uc?export=download&id=1HHPDljWDqxyRqcjP6W-ARAtooLdU57X1",

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