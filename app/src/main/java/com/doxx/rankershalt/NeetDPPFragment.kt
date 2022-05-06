package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_neet_d_p_p.*

class NeetDPPFragment : Fragment(R.layout.fragment_neet_d_p_p) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NeetDppBio.setOnClickListener {
            findNavController().navigate(NeetDPPFragmentDirections.actionNeetDPPFragmentToNeetDppBioFragment())
        }
        NeetDppPhy.setOnClickListener {
            findNavController().navigate(NeetDPPFragmentDirections.actionNeetDPPFragmentToJeeDppPhyFragment())
        }
        NeetDppChem.setOnClickListener {
            findNavController().navigate(NeetDPPFragmentDirections.actionNeetDPPFragmentToJeeDppChemFragment())
        }
    }
}