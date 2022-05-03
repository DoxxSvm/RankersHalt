package com.doxx.rankershalt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_home2.*


class HomeFragment : Fragment(R.layout.fragment_home2) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fhomeJee.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToJeeMaterialsFragment()
            findNavController().navigate(action)
        }
        fhomeNeet.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragment2ToNeetMaterialsFragment()
//            findNavController().navigate(action)
            Toast.makeText(context,"Coming Soon",Toast.LENGTH_SHORT).show()
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
        fhomerequest.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:support@rankershalt.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Request"))

        }
        fhomeperiodic.setOnClickListener {
            val intent= Intent(context, ViewBook::class.java)
            startActivity(intent)
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