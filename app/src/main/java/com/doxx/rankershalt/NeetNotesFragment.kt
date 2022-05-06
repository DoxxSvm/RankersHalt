package com.doxx.rankershalt


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_neet_notes.*


class NeetNotesFragment : Fragment(R.layout.fragment_neet_notes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NeetNotesBio.setOnClickListener {
            findNavController().navigate(NeetNotesFragmentDirections.actionNeetNotesFragmentToNeetNotesBioFragment())
        }
        NeetNotesChem.setOnClickListener {
            findNavController().navigate(NeetNotesFragmentDirections.actionNeetNotesFragmentToJeeNotesChemFragment())
        }
        NeetNotesPhy.setOnClickListener {
            findNavController().navigate(NeetNotesFragmentDirections.actionNeetNotesFragmentToJeeNotesPhyFragment())
        }
    }
}