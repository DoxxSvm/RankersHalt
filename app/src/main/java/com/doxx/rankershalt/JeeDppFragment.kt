package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_jee_dpp.*


class JeeDppFragment : Fragment(R.layout.fragment_jee_dpp) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        JeeDppChem.setOnClickListener {
            findNavController().navigate(JeeDppFragmentDirections.actionJeeDppFragmentToJeeDppChemFragment())
        }
        JeeDppMaths.setOnClickListener {
            findNavController().navigate(JeeDppFragmentDirections.actionJeeDppFragmentToJeeDppMathsFragment())
        }
        JeeDppPhy.setOnClickListener {
            findNavController().navigate(JeeDppFragmentDirections.actionJeeDppFragmentToJeeDppPhyFragment())
        }


    }
}