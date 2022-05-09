package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_comedk_materials.*


class ComedkMaterialsFragment : Fragment(R.layout.fragment_comedk_materials) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fComedkMaterialsbooks.setOnClickListener {
            findNavController().navigate(ComedkMaterialsFragmentDirections.actionComedkMaterialsFragmentToJeeBooksFragment())
        }
        fComedkMaterialsnotes.setOnClickListener {
            findNavController().navigate(ComedkMaterialsFragmentDirections.actionComedkMaterialsFragmentToJeeNotesFragment())
        }
        fComedkMaterialspyq.setOnClickListener {
            findNavController().navigate(ComedkMaterialsFragmentDirections.actionComedkMaterialsFragmentToComedkPyqFragment())
        }
        fComedkMaterialstp.setOnClickListener {
            findNavController().navigate(ComedkMaterialsFragmentDirections.actionComedkMaterialsFragmentToComedkTestPaperFragment())
        }
        fComedkMaterialsdpp.setOnClickListener {
            findNavController().navigate(ComedkMaterialsFragmentDirections.actionComedkMaterialsFragmentToJeeDppFragment())
        }
        fComedkMaterialssyll.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","COMEDK Syllabus")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=16PdwfUTcg0u6_TOJLzAB1ApzF8_dIet7")
            startActivity(intent)
        }

    }
}