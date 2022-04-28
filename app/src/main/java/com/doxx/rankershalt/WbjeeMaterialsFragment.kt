package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_wbjee_materials.*

class WbjeeMaterialsFragment : Fragment(R.layout.fragment_wbjee_materials) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fWbjeeMaterialsbooks.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeBooksFragment())
        }
        fWbjeeMaterialsnotes.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeNotesFragment())
        }
        fWbjeeMaterialspyq.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToWbjeePyqFragment())
        }
        fWbjeeMaterialstp.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToWbjeeTestPaperFragment())
        }
        fWbjeeMaterialsdpp.setOnClickListener {
            findNavController().navigate(WbjeeMaterialsFragmentDirections.actionWbjeeMaterialsFragmentToJeeDppFragment())
        }
    }
}