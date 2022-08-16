package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class JeeBooksMathsFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Arihant Mathematics 41 Years JEE Main and Advanced",
            "Arihant JEE Main MATHEMATICS 40 Days Crash Course",
            "Arihant Differential Calculus",
            "Arihant Integral Calculus",
            "Arihant Play With Graphs",
            "Arihant Trigonometry",
            "Arihant Vector and 3D Geometry",
            "Arihant Algebra",
            "Arihant Coordinate Geometry",
            "Mathematics Class 11 - RS Aggarwal",
            "Mathematics Class 12 - RS Aggarwal",
            "RD Sharma Class 11 Part 1 (Chapter 01 - 19)",
            "RD Sharma Class 11 Part 2 (Chapter 19 - 33)",
            "RD Sharma Class 12 Part 1 (Chapter 01 - 10)",
            "RD Sharma Class 12 Part 2 (Chapter 11 - 19)",
            "NCERT Mathematics Class 11",
            "NCERT Mathematics Class 12 Part 1",
            "NCERT Mathematics Class 12 Part 2",
            "NCERT Exemplar Class 11 Maths",
            "NCERT Exemplar Class 12 Maths",
            "Advanced Problem in Mathematics - Vikas Gupta",
            "Advance Problems in Mathematics Solutions",
            "Coordinate Geometry - SL Loney",
            "Plane Trigonometry - SL Loney",
            "Higher Algebra - Hall & Knight"
        )
        links= arrayOf(
            "https://drive.google.com/uc?id=16_GDiYLiCe6L9LHZvVHgs6AkJbhFS_y-&export=download",
            "https://drive.google.com/uc?export=download&id=1APOK0W5A_vrE3IkEGQLK3lKPYQdEmkF-",
            "https://drive.google.com/uc?id=1-9Ot9890laYQJG6XKncWC4WTY4yGwnQN&export=download",
            "https://drive.google.com/uc?id=1KH4dgVnkrOz1achVss296hHdvZ_uZ7ly&export=download",
            "https://drive.google.com/uc?id=1j2gZlEkFCDWgXrZpeAdaTRuT8tY46jO-&export=download",
            "https://drive.google.com/uc?id=1tv7VrsgUq-yuZBYh6DTR64fL1JecsW8j&export=download",
            "https://drive.google.com/uc?id=1-LzmV3h_qhkQ6P9zclEX8q70pPIlOyPU&export=download",
            "https://drive.google.com/uc?id=1Gl8kR5R8i_XGXoFECYRxc3W_vf75AD9H&export=download",
            "https://drive.google.com/uc?id=1nIru58DaeM1F5Xwsp64k80h58HWK3nlO&export=download",
            "https://drive.google.com/uc?export=download&id=1phsRzLtd3PhSF_BzPk5XiUI0iM5hoXoC",
            "https://drive.google.com/uc?export=download&id=1ZLitn6PNwsAU8OgjwqlikjTfEVFzhSXE",
            "https://drive.google.com/uc?export=download&id=16g8_gu4903_nz1TwabJ6ragNI8IDYZNl",
            "https://drive.google.com/uc?export=download&id=1fRWOj-lDAen_ci8TCKPw0jIkZWRITQOs",
            "https://drive.google.com/uc?export=download&id=1NfpYXKWKbZEB9ErJ7Bc3GHxYtHjeowrQ",
            "https://drive.google.com/uc?export=download&id=1MLEGQXKPC1BFmlGTUrXtzNAsm2_xE7Uy",
            "https://drive.google.com/uc?export=download&id=1YWDiVcQ_PfR18Y4yTTeECtV0pl_mkvgG",
            "https://drive.google.com/uc?export=download&id=1V_5Xmbcj4ZCpB-xL1i4L83n1z0e6DPwS",
            "https://drive.google.com/uc?export=download&id=1zIgPC_v-Gd9SAqLxJUqVcfoBtmSPOPPn",
            "https://drive.google.com/uc?export=download&id=1JLsLvd9nZNonDTtqHjOGhQKSqPMeYzHm",
            "https://drive.google.com/uc?export=download&id=1pgDwYcryJhOdCVaCETlP8PJlVq5Qbnql",
            "https://drive.google.com/uc?export=download&id=1-OA6aWmxiSn0QD9VuNhSFx5p4cQThoab",
            "https://drive.google.com/uc?export=download&id=1-PHErwExZ4yD3qmq27sDrDugk6yvemAf",
            "https://drive.google.com/uc?export=download&id=101FmyNjVHobSs8HxwETKmM1THQg0z4aO",
            "https://drive.google.com/uc?export=download&id=10B9O7kHgQHxy0-96NuMcrOraQmj9zS1k",
            "https://drive.google.com/uc?export=download&id=1-BDGFaKrc0rVoD1x3R-VvH4SoOdf1afw"
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