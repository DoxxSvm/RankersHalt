package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_downloads.*
import java.util.*


class DownloadsFragment : Fragment(R.layout.fragment_downloads),ItemClickedDownloads {
    lateinit var books :ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        downloadRv.layoutManager = LinearLayoutManager(context)
        books= arrayListOf()
        var files= requireActivity().filesDir.listFiles()
        if(files.size>0){
            for(i in 0..(files.size-1) ){
                var name = files[i].toString()
                name = name.replace("/data/user/0/com.doxx.rankershalt/files/","")
                books.add(name)
            }
        }
        else{
            requireActivity().downloadRv.visibility = View.GONE
            //books.add("Please download any book")
            requireActivity().downloadFlag.visibility = View.VISIBLE
        }
        var temp = ArrayList(books)
        var adapter = DownloadsAdapter(books,this)
        downloadRv.adapter=adapter


        downloadsSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextChange(p0: String?): Boolean {
                val search = p0!!.lowercase(Locale.getDefault())
                val filter = ArrayList<String>()
                if(search.isNotEmpty()){
                    books.forEach{
                        if(it.lowercase().contains(search)){
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
                var filter = ArrayList<String>()
                filter = arrayListOf()

                books.forEach{
                    if(it.lowercase().contains(search)){
                        filter.add(it)
                    }
                }
                adapter.items=filter
                adapter.notifyDataSetChanged()
                return false
            }
        })
    }

    override fun onClick(item: String) {
        val intent = Intent(context,ViewBook::class.java)
        intent.putExtra("Filename", item)
        startActivity(intent)
    }
}