package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_jee_books.*


class JeeBooksFragment : Fragment(R.layout.fragment_jee_books) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        JeeBooksPhy.setOnClickListener {
            findNavController().navigate(JeeBooksFragmentDirections.actionJeeBooksFragmentToJeeBooksPhyFragment())
        }
        JeeBooksChem.setOnClickListener {
            findNavController().navigate(JeeBooksFragmentDirections.actionJeeBooksFragmentToJeeBooksChemFragment("Chemistry Books"))
        }
        JeeBooksMaths.setOnClickListener {
            findNavController().navigate(JeeBooksFragmentDirections.actionJeeBooksFragmentToJeeBooksMathsFragment("Maths Books"))
        }
    }

}