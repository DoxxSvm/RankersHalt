package com.doxx.rankershalt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home2.*
import java.lang.Exception


class HomeFragment : Fragment(R.layout.fragment_home2) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fhomeJee.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToJeeMaterialsFragment()
            findNavController().navigate(action)
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
        fhomeshare.setOnClickListener {
                val intent= Intent()
                intent.action=Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"Hey! improve your rank using this amazing app " +
                        "https://play.google.com/store/apps/details?id=com.doxx.rankershalt")
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share To:"))

        }
        fhomeperiodic.setOnClickListener {
            val intent= Intent(context, ViewBook::class.java)
            startActivity(intent)
        }
        fhomeNcert.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToNcertFragment())
        }
        fhomefsheet.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToFormulaSheetFragment())
        }
        fhomerevision.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToRevisionFragment())
        }
        fhomehandbook.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToHandBookFragment())
        }
        fhomeccourse.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToCrashCourseFragment())
        }
        fhometele.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/+wL0Ik29IunQzMTFl"))
                intent.setPackage("org.telegram.messenger");
                startActivity(intent)
            }
            catch (e:Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
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