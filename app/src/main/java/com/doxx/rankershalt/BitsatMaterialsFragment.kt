package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_bitsat_materials.*

class BitsatMaterialsFragment : Fragment(R.layout.fragment_bitsat_materials) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fbitsatMaterialsbooks.setOnClickListener {
            findNavController().navigate(BitsatMaterialsFragmentDirections.actionBitsatMaterialsFragmentToJeeBooksFragment())
        }
        fbitsatMaterialsnotes.setOnClickListener {
            findNavController().navigate(BitsatMaterialsFragmentDirections.actionBitsatMaterialsFragmentToJeeNotesFragment())
        }
        fbitsatMaterialspyq.setOnClickListener {
            findNavController().navigate(BitsatMaterialsFragmentDirections.actionBitsatMaterialsFragmentToBitsatPyqFragment())
        }
        fbitsatMaterialstp.setOnClickListener {
            findNavController().navigate(BitsatMaterialsFragmentDirections.actionBitsatMaterialsFragmentToBitsatTestPaperFragment())
        }
        fbitsatMaterialsdpp.setOnClickListener {
            findNavController().navigate(BitsatMaterialsFragmentDirections.actionBitsatMaterialsFragmentToJeeDppFragment())
        }
    }
}