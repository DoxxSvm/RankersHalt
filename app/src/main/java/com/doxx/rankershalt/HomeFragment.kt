package com.doxx.rankershalt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_home2.*


class HomeFragment : Fragment(R.layout.fragment_home2) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fhomeJee.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToJeeMaterialsFragment()
            findNavController().navigate(action)
            fhomeJee.cardElevation=20.0f
        }
        fhomeNeet.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToNeetMaterialsFragment()
            findNavController().navigate(action)
        }
        fhomecomedk.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToComedkMaterialsFragment()
            findNavController().navigate(action)
        }
        fhomeWbJee.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToWbjeeMaterialsFragment()
            findNavController().navigate(action)
        }
        fhomeBitsat.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToBitsatMaterialsFragment()
            findNavController().navigate(action)
        }
        fhomevit.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToVitMaterialsFragment()
            findNavController().navigate(action)

        }
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    BottomSheetFragment().show(requireActivity().supportFragmentManager,"asd")
                }
            }
            )
    }

}