package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NeetDppBioFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "The Living world DPP",
            "Biological Classification DPP",
            "Plant Kingdom DPP",
            "Animal Kingdom DPP",
            "Morphology of Flowering Plants DPP",
            "Anatomy of Flowering Plants DPP",
            "Structural Organisation in Animals DPP",
            "Cell - The Unit Of Life DPP",
            "Biomolecules DPP",
            "Cell Cycle and Cell Division DPP",
            "Transport in Plants DPP",
            "Mineral Nutrition DPP",
            "Photosynthesis in Higher Plants DPP",
            "Respiration in Plants DPP",
            "Plant Growth and Development DPP",
            "Digestion and Absorption DPP",
            "Breathing and Exchange Of gases DPP",
            "Body Fluids and Circulation DPP",
            "Excretory Products and Their Elimination DPP",
            "Locomotion and Movement DPP",
            "Neural Control and Co-Ordination DPP",
            "Chemical Co-ordination and Integration DPP",
            "Reproduction in Organism DPP",
            "Sexual Reproduction in Flowering Plants DPP",
            "Human Reproduction DPP",
            "Reproductive health DPP",
            "Principles of Inheritance and Variation DPP",
            "Molecular Basics of Inheritance DPP",
            "Evolution DPP",
            "Human Health and Disease DPP",
            "Strategies for Enhancement in Food Production DPP",
            "Microbes in Human Welfare DPP",
            "Biotechnology - Principles and Processes DPP",
            "Biotechnology and Its Applications DPP",
            "Organisms and Populations DPP",
            "Ecosystem DPP",
            "Biodiversity and Its Conservation DPP",
            "Environmental Issues DPP"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1DXn5lP4UgFEEd23WVTqUReyNN_jhIHfV",
            "https://drive.google.com/uc?export=download&id=1-fag7A2BxGjP-UqQ9P9icvgZlddvMaNf",
            "https://drive.google.com/uc?export=download&id=1cO7VJD9YoJGVjuN8ZuJHcuZoPJNcWqHR",
            "https://drive.google.com/uc?export=download&id=1yCM5a6H9PxUN31YRvn_-yNcwbVIr0Qg4",
            "https://drive.google.com/uc?export=download&id=1JE7hcQC-qrDmTqdS--ATnRKxRGmEEZf6",
            "https://drive.google.com/uc?export=download&id=1byfsqWns81KJ2PwqlO5u_KouDJz4x58w",
            "https://drive.google.com/uc?export=download&id=1LLmH0AXj6ha4Rj2xY2GbVzJ3r6Xd9TeM",
            "https://drive.google.com/uc?export=download&id=17wqRUT6TNI1eHQEWkwE8SP4Urjtps6MP",
            "https://drive.google.com/uc?export=download&id=14HFm3IoM-H2l-Jd9h2lqn9Zp9Ro2Jhys",
            "https://drive.google.com/uc?export=download&id=1j1GT1RI00U7xiqDCvH9gdKAwM6o5JllW",
            "https://drive.google.com/uc?export=download&id=1rrlPqcovGUKIJQVehWOYzxmVij_tK_Cu",
            "https://drive.google.com/uc?export=download&id=1aZmPfARR5LskrOhwrx0QHBzyKzFYfpkn",
            "https://drive.google.com/uc?export=download&id=1xGX62Q-ir7zqtBv5rbGP4LUPM6cqPk7V",
            "https://drive.google.com/uc?export=download&id=1k-venbNgRGwwHx9yC6x40YAO30rmKOW5",
            "https://drive.google.com/uc?export=download&id=1NffFKT9Nq5cn6GGoPU8U8hE_-zoaeYhC",
            "https://drive.google.com/uc?export=download&id=1xqs2mlU33gTQh-4vdYnw4NyzOKtx5Kjz",
            "https://drive.google.com/uc?export=download&id=1IIHcGSxPHM9705c6lQVcWHRqyWt0miWk",
            "https://drive.google.com/uc?export=download&id=1cNRTRLGtIYMUwe7K6szpZmuj7sUaqQE_",
            "https://drive.google.com/uc?export=download&id=1k3DwEPGWLdNM-bpBve1Lyc_JiITDhd2j",
            "https://drive.google.com/uc?export=download&id=1agFn1DoNuyIfcgKbtdrms4mgExasIKCu",
            "https://drive.google.com/uc?export=download&id=148xZDwe0Gajr9myFMW3Cqsgt4Tnmf-Ld",
            "https://drive.google.com/uc?export=download&id=1UzykKpqWhzcM8OADStSUCthZGzJHjFrB",
            "https://drive.google.com/uc?export=download&id=1LRW6L6DTbl8v5hBbHadhZBiOFlfn7n8l",
            "https://drive.google.com/uc?export=download&id=1ApgzIFz5CgQqc35ChW7hVmV7tvzTKS6C",
            "https://drive.google.com/uc?export=download&id=1jZAtRPHGFt0zjA0atVMtv04P5G6-QdF4",
            "https://drive.google.com/uc?export=download&id=1w6Y8Ss8MDahxboFHPK2XiGoA91aO7l0N",
            "https://drive.google.com/uc?export=download&id=1_pnmn8E_qOIXpTz8jTFHMjpkgt58w0QD",
            "https://drive.google.com/uc?export=download&id=1LZMDZLMx4jaHcE0hwJ1dDKb6_O4UvFXd",
            "https://drive.google.com/uc?export=download&id=1riA1V6WxPPmh2O9RdjBl0AbXcLs6c1JY",
            "https://drive.google.com/uc?export=download&id=1RBoy-dgTav3FC2-wbrOeeDIB9m1Qkx60",
            "https://drive.google.com/uc?export=download&id=1N5wFdk_mi6KcxGiycSTt_4TKYwYwudqE",
            "https://drive.google.com/uc?export=download&id=15C-YaQg76hB5erhGusZ1U7z-SjETcw8d",
            "https://drive.google.com/uc?export=download&id=1ZZkPowviw8hhecpxPqhNQL6la0XGvbcf",
            "https://drive.google.com/uc?export=download&id=1-8XpPiO0FQ4iwkEGKF18_s3lqk00hRB0",
            "https://drive.google.com/uc?export=download&id=1Jb1s6PuU_neKy6QMUVsXQ8UpLIJ8Kh11",
            "https://drive.google.com/uc?export=download&id=15ffhqYRk6WzI-GWyVufnkRZdf392m0v2",
            "https://drive.google.com/uc?export=download&id=1Y4qzdnSpY0CNjN863gyURZBa2wqhJpsb",
            "https://drive.google.com/uc?export=download&id=1I6WH5hth2kMKKU3rxb8C9036rAcFZhmk"
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