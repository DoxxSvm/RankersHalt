package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeNotesPhyFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Alternatng Current Handwritten Notes",
            "Basic Trigonometry Handwritten Notes",
            "Calorimetry Handwritten Notes",
            "Capacitor Handwritten Notes",
            "Current Electricity Handwritten Notes",
            "Differentiation and Integration Handwritten Notes",
            "Electric Potential Handwritten Notes",
            "Electrostatics Handwritten Notes",
            "EM Waves Handwritten Notes",
            "EMI Handwritten Notes",
            "Gaseous State Handwritten Notes",
            "Graph Practicle Handwritten Notes",
            "Kinematics Handwritten Notes",
            "Kinetic Theory of Gases Handwritten Notes",
            "Magnetism Handwritten Notes",
            "Mode of Heat Transfer Handwritten Notes",
            "Motion Handwritten Notes",
            "Newton Laws of Motion Handwritten Notes",
            "Projectile Motion Handwritten Notes",
            "Ray Optics Handwritten Notes",
            "Refraction of Light Handwritten Notes",
            "Theory of Gases Handwritten Notes",
            "Thermodynamics Handwritten Notes",
            "Unit and Measurement Handwritten Notes",
            "Vectors Handwritten Notes",
            "Wave Optics Handwritten Notes"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1ZXn4u9Lz1I1Iap0GdcrvCxyoYvcDUSOJ",
            "https://drive.google.com/uc?export=download&id=1We6wzRiLNbXEm44-Cyo76DIZKEOwbVzZ",
            "https://drive.google.com/uc?export=download&id=18KLJ9GhHcYI2IFX43H5ZfkiJW1P6oi9s",
            "https://drive.google.com/uc?export=download&id=1KyZYLk9qMclkQnpflp46B9ZG1X8UjSho",
            "https://drive.google.com/uc?export=download&id=19tBbSEkTYCzodpwPQ2C6Rj1O5_djY-yP",
            "https://drive.google.com/uc?export=download&id=1u-790MME4t-zZcMyULgMLuv5hRwWpCf4",
            "https://drive.google.com/uc?export=download&id=1k1ohEpY_wy_NpDGYHs8YdMbQlZicBx36",
            "https://drive.google.com/uc?export=download&id=1YTjckQZ7h0HEA1pMQBDPnqV3hfN_qizd",
            "https://drive.google.com/uc?export=download&id=1VLABBcZHiwIM_IZy6tKpW6EyoyK9j4yj",
            "https://drive.google.com/uc?export=download&id=1TtnEgI2Ty8QJB1bzvxlIu6fZV_nw0ggL",
            "https://drive.google.com/uc?export=download&id=1gsn4GBDaZhpEd6Hh0nQDO8V105j94sMT",
            "https://drive.google.com/uc?export=download&id=1IbMRB7EL7VsKliL2omSkNmHdViXBhXxL",
            "https://drive.google.com/uc?export=download&id=1kCNDSTRTNnyipRpAh38DMQRYMC8SYYnj",
            "https://drive.google.com/uc?export=download&id=16K8mPS7hkYrVqsGY2OEdMZoZ9Eus-CVG",
            "https://drive.google.com/uc?export=download&id=1i9ayO0CSe_bUWcFoo4XVii_5-R5TrH5D",
            "https://drive.google.com/uc?export=download&id=1T94yCD3ha0jQ3Q4D06OPgruvZflOmYa5",
            "https://drive.google.com/uc?export=download&id=1DHQh99aufCO2cZEjQ4dN4qYZLUo7Nb5J",
            "https://drive.google.com/uc?export=download&id=11RDyBIgQ8yfT_x3aB-aqj7GEfKH0Wmi0",
            "https://drive.google.com/uc?export=download&id=1xZjzei7q26EdYnUcV6UBwuiK28MZG0od",
            "https://drive.google.com/uc?export=download&id=1ojYuxFVSYsUfK1lCwCuz0neiJ0Z-Fshu",
            "https://drive.google.com/uc?export=download&id=1guEsZbC4Uk9KdC-nsFZAd_Q7kmehH_en",
            "https://drive.google.com/uc?export=download&id=1Gw_-kXXknzI93USDw2zYrpRMkx7nTSbZ",
            "https://drive.google.com/uc?export=download&id=168smeletsJrf5DJTfjLIs5oR3NjWJkcT",
            "https://drive.google.com/uc?export=download&id=1hArkHHH2JvaB6QeP5sNjlX32ssQa6Ljn",
            "https://drive.google.com/uc?export=download&id=1P6DcnKSv-upwQu4wFZnvzNipArN5Soph",
            "https://drive.google.com/uc?export=download&id=1ddT5DJAjn6stPtfIiMuXwEJljkxrm2Qc"

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