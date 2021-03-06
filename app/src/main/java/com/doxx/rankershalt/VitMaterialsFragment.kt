package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_vit_materials.*

class VitMaterialsFragment : Fragment(R.layout.fragment_vit_materials) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fVitMaterialsbooks.setOnClickListener {
            findNavController().navigate(VitMaterialsFragmentDirections.actionVitMaterialsFragmentToJeeBooksFragment())
        }
        fVitMaterialsnotes.setOnClickListener {
            findNavController().navigate(VitMaterialsFragmentDirections.actionVitMaterialsFragmentToJeeNotesFragment())
        }
        fVitMaterialspyq.setOnClickListener {
            findNavController().navigate(VitMaterialsFragmentDirections.actionVitMaterialsFragmentToVitPyqFragment())
        }
        fVitMaterialstp.setOnClickListener {
            findNavController().navigate(VitMaterialsFragmentDirections.actionVitMaterialsFragmentToVitTestPaperFragment())
        }
        fVitMaterialsdpp.setOnClickListener {
            findNavController().navigate(VitMaterialsFragmentDirections.actionVitMaterialsFragmentToJeeDppFragment())
        }
        fVitMaterialssyll.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","VITEEE Syllabus")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1YW7ziXo5hbcQAPmsu08HSiiG0CUd6Szq")
            startActivity(intent)
        }
    }
}