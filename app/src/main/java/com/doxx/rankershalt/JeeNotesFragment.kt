package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_jee_notes.*


class JeeNotesFragment : Fragment(R.layout.fragment_jee_notes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        JeeNotesChem.setOnClickListener {
            findNavController().navigate(JeeNotesFragmentDirections.actionJeeNotesFragmentToJeeNotesChemFragment())
        }
        JeeNotesMaths.setOnClickListener {
            findNavController().navigate(JeeNotesFragmentDirections.actionJeeNotesFragmentToJeeNotesMathsFragment())
        }
        JeeNotesPhy.setOnClickListener {
            findNavController().navigate(JeeNotesFragmentDirections.actionJeeNotesFragmentToJeeNotesPhyFragment())
        }

    }
}