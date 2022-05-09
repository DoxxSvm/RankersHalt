package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wbjee_materials.*

class WbjeeMaterialsFragment : Fragment(R.layout.fragment_wbjee_materials) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fWbjeeMaterialsbooks.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeBooksFragment())
        }
        fWbjeeMaterialsnotes.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeNotesFragment())
        }
        fWbjeeMaterialspyq.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToWbjeePyqFragment())
        }
        fWbjeeMaterialstp.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToWbjeeTestPaperFragment())
        }
        fWbjeeMaterialsdpp.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeDppFragment())
        }
        fWbjeeMaterialssyll.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","WBJEE Syllabus")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1-JouuDbasdznz4kiwxd01EWMfsJoG0Iv")
            startActivity(intent)
        }
    }
}