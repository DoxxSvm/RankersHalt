package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeNotesChemFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Acid, Base and Salt",
            "Alcohol phenol ether",
            "Aldehyde, Ketone and Carboxylic acid",
            "Allotropes",
            "Atomic Structure",
            "Basic Concepts",
            "Bonding",
            "Carbanion and Its Reaction",
            "Carbocation",
            "Chemical Bonding",
            "Chemical Kinetics",
            "Dipole Moment",
            "Empirical Formula",
            "Equilibrium",
            "General Organic Chemistry",
            "GOC",
            "Halogen Derivatives",
            "Hybridisation",
            "Inorganic Chemistry",
            "Ionic Bond",
            "Isomerism 1",
            "Isomerism 2",
            "Metallurgy",
            "Mole concept",
            "Organic Chemistry Basics",
            "Organic Chemistry",
            "OrganicNameReactions",
            "P-d-f block",
            "Periodic Table",
            "Solid State",
            "Solutions",
            "Stoichiometry",
            "Surface Chemistry"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1SlBizfUGWi911s8nlOmH1P9OIIoGA30k",
            "https://drive.google.com/uc?export=download&id=1Ztu9eoCR6MID_uVtRtPEaGrik9kMPibZ",
            "https://drive.google.com/uc?export=download&id=1NEXHOULMaT14Qb2LdBJOSDSnpI60WgXq",
            "https://drive.google.com/uc?export=download&id=1Kp8cpEWqDScIyvKP3j31qez8Fl1AxnVS",
            "https://drive.google.com/uc?export=download&id=16a1MZCoQdAT-ppbl7n3HkQMxxVkszDsZ",
            "https://drive.google.com/uc?export=download&id=1XLHzsLLfl-FKG-7c3z0LlpGpi2_aNZcU",
            "https://drive.google.com/uc?export=download&id=1H62aT_PpTqt0HbQyfUSfLsJAurd8Vjgd",
            "https://drive.google.com/uc?export=download&id=10CrgpBKmJ-7rZ0e6ZIVHJ7QUCc57k96O",
            "https://drive.google.com/uc?export=download&id=13PXr8w_ykd4RDgblSrmXaSCFc9_8M2Gd",
            "https://drive.google.com/uc?export=download&id=1azQ3M4eBgiSsf3XWcYjCu-tD2plqHB2l",
            "https://drive.google.com/uc?export=download&id=1cKcREFevchEkshJBnq-ozuVPxhiMvact",
            "https://drive.google.com/uc?export=download&id=1ke76BWo_HA1CSXQvVPfF0QaBiPrzRd1P",
            "https://drive.google.com/uc?export=download&id=1_EM1W_l2l8NRbHuPFVKCpU6WV-LUEYX9",
            "https://drive.google.com/uc?export=download&id=1jxXDocQpbUzecCxXIIwUAS8dvMoqYIGn",
            "https://drive.google.com/uc?export=download&id=1xQz4lGLC4hs10yIbz4ATDsGfdVDv4kIh",
            "https://drive.google.com/uc?export=download&id=1r0cJuaUxogzoFmOJt0gFXDpjYi-eaMoE",
            "https://drive.google.com/uc?export=download&id=1mCcRKF8j7xSOMt_oJSInSpL2uCLzUZrQ",
            "https://drive.google.com/uc?export=download&id=1Yi6aOJhwvNIEOSgz-xjkcqi9bupvGNWw",
            "https://drive.google.com/uc?export=download&id=1mQ9_YjgrsPDZs40BxdiNiMOz10u6F4Ls",
            "https://drive.google.com/uc?export=download&id=1EiF-jVc70Z0qMTh1rSHH8uABlZm94h-j",
            "https://drive.google.com/uc?export=download&id=1r7enatdmD0PNz9_3wWty6QIjTLSeZTna",
            "https://drive.google.com/uc?export=download&id=1oviOscui4lZGgm7eBq4gpSdTfKOFAeUy",
            "https://drive.google.com/uc?export=download&id=1m5bj-1CWc--sIM5dwpqm8mj-CjAz5eY4",
            "https://drive.google.com/uc?export=download&id=1d9fl7fei30vOq68OXI8x0vvfOo9g2M7r",
            "https://drive.google.com/uc?export=download&id=1VAFjpZUwoSkQ9YP36SomDC7tdd5NhkCd",
            "https://drive.google.com/uc?export=download&id=1LqQHXkfN-RtHQFE7MskAmjKL3bfllMmC",
            "https://drive.google.com/uc?export=download&id=1Iz1YiG31Bl6v0RmGHHfyMTqlKvjKpKMN",
            "https://drive.google.com/uc?export=download&id=1kBrhKYgXo1lXWX336MBH7BDyiXVLDWi4",
            "https://drive.google.com/uc?export=download&id=1hDU02vcj5F00AfE-CBsL2m6TUCAFmt5S",
            "https://drive.google.com/uc?export=download&id=13SelBiS-fnjvxLkKhj6UjyXsgXUCVzR5",
            "https://drive.google.com/uc?export=download&id=1Lhh27Rnh4dpWxNVP0mKe3-9kLuG3M3QQ",
            "https://drive.google.com/uc?export=download&id=19ChoaPvt7cXjzJaUdRqieXSyHh8OVV_p",
            "https://drive.google.com/uc?export=download&id=1J9iKhF0CDUrpSpcHS4AW8LXnbgY_mEX3"
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