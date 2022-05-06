package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*

class NcertChemFragment: Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)

        bookName= arrayOf(
            "Aldehydes, Ketones and Carboxylic Acid NCERT Highlighted",
            "Amines NCERT Highlighted",
            "Biomolecules NCERT Highlighted",
            "Chemical Bonding and Molecular Structure NCERT Highlighted",
            "Chemical Kinetics NCERT Highlighted",
            "Chemistry in Everyday Life NCERT Highlighted",
            "Coordination Chemistry NCERT Highlighted",
            "D and F block elements NCERT Highlighted",
            "Electrochemistry NCERT Highlighted",
            "Environmental Chemistry NCERT Highlighted",
            "Haloalkanes and haloarenes NCERT Highlighted",
            "Hydrogen NCERT Highlighted",
            "P-block elements NCERT Highlighted",
            "Periodic Table NCERT Highlighted",
            "Polymers NCERT Highlighted",
            "Solid State NCERT Highlighted",
            "Solution NCERT Highlighted",
            "Some Basic Concept of Chemistry NCERT Highlighted",
            "State of Matter NCERT Highlighted",
            "Structure of Atom NCERT Highlighted",
            "Surface Chemistry NCERT Highlighted",
            "S-Block elements NCERT Highlighted"
        )
        links= arrayOf(
            "https://drive.google.com/uc?export=download&id=1mPWzL-kn8pmpg5Wqg8o_3j0tf-6QrkmZ",
            "https://drive.google.com/uc?export=download&id=1fDVdSeaAK66XvJ1XjxIs5iAhq3hcVp8g",
            "https://drive.google.com/uc?export=download&id=1AGz4xhZr54tbxHMZjDmhgW26rO5jqoIp",
            "https://drive.google.com/uc?export=download&id=1-CNoLnphOcZaQDlfbrtVltHksSjf5cyn",
            "https://drive.google.com/uc?export=download&id=1ttJh1GZWd6MJvAGZfZLICrnHhnvn5Qsn",
            "https://drive.google.com/uc?export=download&id=1ksFJB37xZ0YctZak8ElmXiCkc9lJoUbV",
            "https://drive.google.com/uc?export=download&id=19EdRFQVxvvuUbXhtycUqi9S2OMmH0RoG",
            "https://drive.google.com/uc?export=download&id=1R7lu779NhZmTPgEDprr--qlZXvuH2xP7",
            "https://drive.google.com/uc?export=download&id=11n0OnGNyOjONXBohY2l2OWq0osQgxE40",
            "https://drive.google.com/uc?export=download&id=1SfsnmeJb6y51tJqXsoC_PGNwCgdRnTLX",
            "https://drive.google.com/uc?export=download&id=1ZX6D1aqDjba4kR8r-RktzFq_POb2prok",
            "https://drive.google.com/uc?export=download&id=1Vol-p1K8sADp_gHGHWYg34tSxZiYF1Nt",
            "https://drive.google.com/uc?export=download&id=1bhPmFaAhqx3xuV8xB7IgsEdIsLxbZAE2",
            "https://drive.google.com/uc?export=download&id=1tqeVtVINM04fGaidkrHS4fp0vvwjfkHC",
            "https://drive.google.com/uc?export=download&id=1KmEzcgkmXOvw96ZkyDk_e-3UxOJQOcHy",
            "https://drive.google.com/uc?export=download&id=/1VsvhDrFmy2YlOuyETipm33xKZA4S8C-a",
            "https://drive.google.com/uc?export=download&id=12vTcuDDrkXIhgKJFqjHN6HbSqaic_nT7",
            "https://drive.google.com/uc?export=download&id=1TChAzplReJq7u7PlnUa-8B1Af4Kb3jQE",
            "https://drive.google.com/uc?export=download&id=15vOPCRzU-iciE12n0erqA8NxaeINUwaL",
            "https://drive.google.com/uc?export=download&id=1_U5MsuRZjayycOqTaArUTLjYkdUn2gb7",
            "https://drive.google.com/uc?export=download&id=1twbW3eaqHYdS01eQ7MivfLuQcDST4-U3",
            "https://drive.google.com/uc?export=download&id=1Iw7iEU7MgbPi81ips-yv6UENcLfOXH1R"


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