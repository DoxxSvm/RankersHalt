package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_jee_books_list.*
import java.util.*
import kotlin.collections.ArrayList


class JeeDppChemFragment : Fragment(R.layout.fragment_jee_books_list),ItemClicked {
    lateinit var adapter:Adapter
    lateinit var imageId:Array<Int>
    lateinit var bookName:Array<String>
    lateinit var links:Array<String>
    lateinit var bookArrayList: ArrayList<Books>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ecy.layoutManager= LinearLayoutManager(context)
        bookName= arrayOf(
            "The Solid State",
            "Solutions",
            "Electrochemistry",
            "Chemical Kinetics",
            "Surface Chemistry",
            "Metallurgy",
            "p-Block Elements",
            "d-and f-Block Elements",
            "Coordination Compounds",
            "Haloalkanes and Haloarenes",
            "Alcohols, Phenols and Ethers",
            "Aldehydes, Ketones and carboxylic acids",
            "Amines",
            "Blomolecules",
            "Polymers",
            "Chemistry In everyday life",
            "Salt analysis"
        )
        links= arrayOf(
            "https://drive.google.com/u/0/uc?id=14Zg3IqpCHJ1IH-7SIlrTNPDZZTNttl3D&export=download",
            "https://drive.google.com/uc?export=download&id=1xJbpXiyzpjtdqbJlBNss6iAWNqlwSSSa",
            "https://drive.google.com/uc?export=download&id=1e0jcF-BMVeg_MsW_7oKQd9w9E_BIi0e3",
            "https://drive.google.com/uc?export=download&id=1covCMV3jtD9NLFYdKdp4hxJw7hAUUp7Y",
            "https://drive.google.com/uc?export=download&id=1ng1gc_25w1rKJKO42WIfsbKq8NvVHXFz",
            "https://drive.google.com/uc?export=download&id=1y7zuihvAxmEwDV1Ho8DXRF6aIiYTdM-q",
            "https://drive.google.com/uc?export=download&id=1NCA2Hdm4ZrzLDkwpOhlcPBxamhsDpBnr",
            "https://drive.google.com/uc?export=download&id=1wq4GJ7Lw7gH7koqawa1ePpOvFZOGqVgG",
            "https://drive.google.com/uc?export=download&id=1LK7zlANp-9XhrwT5m7O3PAyoLOGaxvwn",
            "https://drive.google.com/uc?export=download&id=1CllTMkTpb0kprNR0dXyiG6CzvQZXSQWy",
            "https://drive.google.com/uc?export=download&id=1xMX5L78axxix0IumGm-sv6lJSOGvnPCq",
            "https://drive.google.com/uc?export=download&id=1dY5n2C6g1DrbrlNz0BPHmfQhYqCpfwaL",
            "https://drive.google.com/uc?export=download&id=1lUAl07ZZXErKwJ6Bxe4jXFVsJnq6wML9",
            "https://drive.google.com/uc?export=download&id=17kDmJtNZNvqdPHZBFqyUpAONxjWnzA__",
            "https://drive.google.com/uc?export=download&id=1hVBNQNIZcGdbS8EIuPc66lEFD40z1tsy",
            "https://drive.google.com/uc?export=download&id=1WCe279k0hy2oL-3f7sx9sE7_df46qVfA",
            "https://drive.google.com/uc?export=download&id=1waRIGa80lpdZPPaEe2DTaFifS1qoxJ00"
        )
        bookArrayList= arrayListOf()
        fetchData()
        var temp = ArrayList<Books>()
        temp.addAll(bookArrayList)
        adapter= Adapter(context,bookArrayList,this)
        ecy.adapter=adapter
        bookListSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextChange(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                if(search.isNotEmpty()){
                    var filter = ArrayList<Books>()
                    bookArrayList.forEach{
                        if(it.bookName.lowercase().contains(search)){
                            filter.add(it)
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
                    if(it.bookName.lowercase().contains(search)){
                        filter.add(it)
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

        val intent = Intent(context,PdfView::class.java)
        intent.putExtra("title",item.bookName)
        intent.putExtra("link",item.link)
        startActivity(intent)

    }
}