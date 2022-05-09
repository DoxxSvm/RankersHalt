package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeBooksPhyFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant JEE Mains Physics in 40 days",
            "Arihant Physics 41 years JEE Main and Advanced",
            "DC Pandey Electricity and Magnetism",
            "DC Pandey Mechanics Volume 1",
            "DC Pandey Mechanics Volume 2",
            "DC Pandey Optics And Modern Physics",
            "DC Pandey Waves And Thermodynamics",
            "IE Irodov Problems in General Physics",
            "Concept of Physics HC Verma Volume 1",
            "Concept of Physics HC Verma Volume 2",
            "Concept of Physics HC Verma Solutions Volume 1",
            "Concept of Physics HC Verma Solutions Volume 2",
            "Fundamental of Physics - Halliday Resnick",
            "Problems in Physics - SS Crotov",
            "SL Arora (Class 11) Part 1 Chapter 01-08",
            "SL Arora (Class 11) Part 2 Chapter 09-15",
            "SL Arora (Class 12) Part 1 Chapter 01-06",
            "SL Arora (Class 12) Part 2 Chapter 07-09",
            "SL Arora (Class 12) Part 3 Chapter 10-15",
            "Arihant Master the NCERT Physics Class 11 Part 1",
            "Arihant Master the NCERT Physics Class 11 Part 2",
            "Arihant Master the NCERT Physics Class 12 Part 1",
            "Arihant Master the NCERT Physics Class 12 Part 2"
        )
        links= arrayOf(
            "https://drive.google.com/utc?d=1_1uxcpSENN63ST7Rcnx5WINOvnlpF3O5&export=download",
            "https://drive.google.com/uc?export=download&id=1tlUgqTk-m62tEPbaOIzG9i7Z4v1959EW",
            "https://drive.google.com/uc?export=download&id=19j3RXKKL4g4gp7fkGID3uufyqq0vHJrM",
            "https://drive.google.com/uc?export=download&id=1olzusP6d8uib5jYvQBoGO2SV4YMiwrzX",
            "https://drive.google.com/uc?export=download&id=1NB1pi33_QrZHxLuNmvos59Nu7p3gfNCV",
            "https://drive.google.com/uc?export=download&id=13gWmgB9uxVfWkyvOLdKk9NcvcAlsC_J7",
            "https://drive.google.com/uc?export=download&id=1WmJC1DCyJFxaTHhwZO5aAKoNisX3XUwx",
            "https://drive.google.com/uc?export=download&id=13IaZAekGKVgM1EhHh_-ODzciRcxXzUkH",
            "https://drive.google.com/uc?export=download&id=1kZHkkzAbeofxsn_gkh_0Gprvc4jnCuoZ",
            "https://drive.google.com/uc?export=download&id=1UVmhHW2MWgwoYDG6gFE-KQYVcE3Ki3q_",
            "https://drive.google.com/uc?export=download&id=1b5ZWp1vMlgScrb3YY2T-tHBLdl9QFupC",
            "https://drive.google.com/uc?export=download&id=1-PCmB2Q60wYrUvDHsO7b3ShGT46wyiKY",
            "https://drive.google.com/uc?export=download&id=1fyDEfHUjxpemTFOSI4xg4dQgGhQP8zou",
            "https://drive.google.com/uc?export=download&id=1XrxijpjrJpQN_0grNhmm7TnWalQzTYF6",
            "https://drive.google.com/uc?export=download&id=1rnOdGe_p7XgwLgIDg7yg2yIM42uzLTx4",
            "https://drive.google.com/uc?export=download&id=1lF3TGO9KsRWSzqrn3ShW2_LPBLtSqlua",
            "https://drive.google.com/uc?export=download&id=1hopZDc7rcE-11qbZHi-EfHvljdlbMXkm",
            "https://drive.google.com/uc?export=download&id=1rY7Jp5IQ_dM8Plc5kTjpAbKoloc1hL34",
            "https://drive.google.com/uc?export=download&id=18Hp-N9mI8l8FribtWkZ5hSn7SvMQ6hX0",
            "https://drive.google.com/uc?export=download&id=1UJry_BCKp4mLqWrrIlpDPnKjlJWYZLN7",
            "https://drive.google.com/uc?export=download&id=18yZnYd-w3fiKNm7dJwiSOCX4ftjb1q4x",
            "https://drive.google.com/uc?export=download&id=1RhqqJWygEW-Az2-kbeyc6MUKyK9HQ3R4",
            "https://drive.google.com/uc?export=download&id=1VEkDzTF5WpMBxaAletaR9VI-m9R2B1rA"
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