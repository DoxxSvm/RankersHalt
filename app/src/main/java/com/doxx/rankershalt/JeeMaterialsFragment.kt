package com.doxx.rankershalt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_jee_materials.*


class JeeMaterialsFragment : Fragment(R.layout.fragment_jee_materials) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            fJeeMaterialsbooks.setOnClickListener {
                findNavController().navigate(JeeMaterialsFragmentDirections.actionJeeMaterialsFragmentToJeeBooksFragment())
            }
            fJeeMaterialsnotes.setOnClickListener {
                findNavController().navigate(JeeMaterialsFragmentDirections.actionJeeMaterialsFragmentToJeeNotesFragment())
            }
            fJeeMaterialspyq.setOnClickListener {
                findNavController().navigate(JeeMaterialsFragmentDirections.actionJeeMaterialsFragmentToJeePyqFragment())
            }
            fJeeMaterialstp.setOnClickListener {
                findNavController().navigate(JeeMaterialsFragmentDirections.actionJeeMaterialsFragmentToJeeTestPaperFragment())
            }
            fJeeMaterialsdpp.setOnClickListener {
                findNavController().navigate(JeeMaterialsFragmentDirections.actionJeeMaterialsFragmentToJeeDppFragment())
            }
            //loadAds()
        }
    }

    fun loadAds(){
        MobileAds.initialize(context) {}

        val adRequest = AdRequest.Builder().build()
        fJeeMaterialsadView.loadAd(adRequest)
        fJeeMaterialsadView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Toast.makeText(context,"Ad loaded", Toast.LENGTH_SHORT).show()
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }


    }


}