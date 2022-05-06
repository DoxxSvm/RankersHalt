package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetNotesBioFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Animal Kingdom Handwritten Notes",
            "Application of Biotechnology Handwritten Notes",
            "Biomolecules Handwritten Notes",
            "Cardiac Cycle Handwritten Notes",
            "Cell Biology Handwritten Notes",
            "Circulatory System Handwritten Notes",
            "Circulatory System and Cardiac Cycle Handwritten Notes",
            "Digestive System Handwritten Notes",
            "Ecology Handwritten Notes",
            "Ecosystem Handwritten Notes",
            "Endocrine System Handwritten Notes",
            "Evolution Handwritten Notes",
            "Genetics Handwritten Notes",
            "Human Excretory System Handwritten Notes",
            "Human Genetics Handwritten Notes",
            "Human Health and Disease Handwritten Notes",
            "Human Reproduction Handwritten Notes",
            "Kingdom Fungi Handwritten Notes",
            "Kingdom Plantae Handwritten Notes",
            "Microbes in Human welfare Handwritten Notes",
            "Nervous System Handwritten Notes",
            "Photosynthesis Handwritten Notes",
            "Plant Anatomy Handwritten Notes",
            "Plant Growth and Development Handwritten Notes",
            "Respiratory system Handwritten Notes",
            "Skeletal System Handwritten Notes",
            "Structural Oraganisation in Animals Handwritten Notes",
            "Transport in Plants Handwritten Notes"

        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1sunnqYB-mqsfkSL__-KZ2asP5k2ZT68J",
            "https://drive.google.com/uc?export=download&id=1UWceSHe8ofW9evkosktCrXZmahm1-9NE",
            "https://drive.google.com/uc?export=download&id=1G7nAluN_y11ATpzjhRf_Pgj2iyIbgBbs",
            "https://drive.google.com/uc?export=download&id=1Ht8oSuo_pJIpscMM3VF5G8GN8j6POEpJ",
            "https://drive.google.com/uc?export=download&id=1rw2KDipsAiTj7WsmqEWHADYaMyI3zD0Z",
            "https://drive.google.com/uc?export=download&id=18uoQbsRVwqicoTbfBeciRp9oy-CX08ct",
            "https://drive.google.com/uc?export=download&id=11mMW4uiAKqI0n0LGqKn_De0w4qi6fJN1",
            "https://drive.google.com/uc?export=download&id=11oR6YyZNyW84jltE53PbjIk8hDFw7l82",
            "https://drive.google.com/uc?export=download&id=1Z4KxNzNlU9I-ZLVEdasxCNjPQgSD2cO5",
            "https://drive.google.com/uc?export=download&id=1mXI5kkYrD0QEC2WW3aPjUFzlgTRia67z",
            "https://drive.google.com/uc?export=download&id=1lnlF0RvxgDfSIBeSTIQgUwGNF8ygVhxY",
            "https://drive.google.com/uc?export=download&id=1iWWlK14lkgfbl17zwt85d2TdkrSZNKuq",
            "https://drive.google.com/uc?export=download&id=1D1AzL9uQVPfRoj0oRo_ayMdhVG2yV7DH",
            "https://drive.google.com/uc?export=download&id=1oC8g7Gj8k4xv9sU9TrLidjbIWWs8cj2X",
            "https://drive.google.com/uc?export=download&id=1YD1eSd8zRcd5eVGvtGyi6tXf3U3iLpaj",
            "https://drive.google.com/uc?export=download&id=1rQGeM1EF7kaeZgKsJfAUAA2b1bh3FJwf",
            "https://drive.google.com/uc?export=download&id=1TBV0ya91T5-SgIlYV2vyDPfFSt39PaES",
            "https://drive.google.com/uc?export=download&id=1uWBRmoTCBx1eip_m9SbKO1s6WLVRsqWK",
            "https://drive.google.com/uc?export=download&id=19D24iX6J0g_uqPQ2c7tA408oFPFiL7WQ",
            "https://drive.google.com/uc?export=download&id=1pgrjGje4wR4zYFI4E8cS8BwoyTlR9B7l",
            "https://drive.google.com/uc?export=download&id=1y4SnNtyE6MHu085Bx4p5pzlFyUyUaFli",
            "https://drive.google.com/uc?export=download&id=1ShvcgPuIoQvzHJu94-Uo3fnh3kBQksn-",
            "https://drive.google.com/uc?export=download&id=1mx73dP77HwISF5kRLOR-1VhzSIPtLkUo",
            "https://drive.google.com/uc?export=download&id=1Ez23KWQuqADz6n_3Fyi40rqQPxEaLg4n",
            "https://drive.google.com/uc?export=download&id=10-pCuAKvH2RUzP50HK0Legz52R6afjew",
            "https://drive.google.com/uc?export=download&id=1tJmOn7Jp9mJiuADLoMY4p-lVs2jYCQeG",
            "https://drive.google.com/uc?export=download&id=1dcBv2EX5Zr0AjK38ty0wQRq_Z3Efsw7w",
            "https://drive.google.com/uc?export=download&id=1esdVjS825mURxUZyCPG5a8YthFtzRQzx",
            "https://drive.google.com/uc?export=download&id=1JPEF3JolBiwWCbm4NWycJovh103HSO0I"
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