package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_ncert.*


class NcertFragment : Fragment(R.layout.fragment_ncert) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NcertBio.setOnClickListener {
            findNavController().navigate(NcertFragmentDirections.actionNcertFragmentToNcertBioFragment())
        }
        NcertChem.setOnClickListener {
            findNavController().navigate(NcertFragmentDirections.actionNcertFragmentToNcertChemFragment())
        }
    }
}