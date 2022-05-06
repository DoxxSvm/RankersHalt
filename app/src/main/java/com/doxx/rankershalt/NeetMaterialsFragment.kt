package com.doxx.rankershalt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_neet_materials.*


class NeetMaterialsFragment : Fragment(R.layout.fragment_neet_materials) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fNeetMaterialsbooks.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetBooksFragment())
        }
        fNeetMaterialsnotes.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetNotesFragment())
        }
        fNeetMaterialspyq.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetPyqFragment())
        }
        fNeetMaterialstp.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetTestPaperFragment())
        }
        fNeetMaterialsdpp.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetDPPFragment())
        }
        neetmt.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetTestPaperFragment())
        }
        neetpyq.setOnClickListener {
            findNavController().navigate(NeetMaterialsFragmentDirections.actionNeetMaterialsFragmentToNeetPyqFragment())
        }

    }
}