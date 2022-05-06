package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_neet_books.*


class NeetBooksFragment : Fragment(R.layout.fragment_neet_books) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NeetBooksBio.setOnClickListener {
            findNavController().navigate(NeetBooksFragmentDirections.actionNeetBooksFragmentToNeetBooksBioFragment())
        }
        NeetBooksChem.setOnClickListener {
            findNavController().navigate(NeetBooksFragmentDirections.actionNeetBooksFragmentToNeetBooksChemFragment())
        }
        NeetBooksPhy.setOnClickListener {
            findNavController().navigate(NeetBooksFragmentDirections.actionNeetBooksFragmentToNeetBooksPhyFragment())
        }
    }
}