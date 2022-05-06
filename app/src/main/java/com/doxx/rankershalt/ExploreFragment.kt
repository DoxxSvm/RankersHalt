package com.doxx.rankershalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_explore.*


class ExploreFragment : Fragment(R.layout.fragment_explore) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fexploreJeeMain.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","Jee Main Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1DIjspQGEFJNxWTl5YOd9lSPULiakfUdw")
            startActivity(intent)
        }
        fexplorejeeadv.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","Jee Advanced Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1lxCVMUZv3XNYPwbWzuG3LEhddbo18c1x")
            startActivity(intent)
        }
        fexplorecomedk.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","COMEDK Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1UkCq3SRq6d07uSSPDl2YgMT2PKcUlw7E")
            startActivity(intent)
        }
        fexploreWbJee.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","WBJEE Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1XpMxl20gPeOXiZPtjFDfgrCFli2Zut8i")
            startActivity(intent)
        }
        fexploreneet.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","NEET Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=14w34H7IU0mBf0_642I5FWSjhJGRSGTjZ")
            startActivity(intent)
        }
        fexploreBitsat.setOnClickListener {
            val intent = Intent(context,Downloader::class.java)
            intent.putExtra("title","BITSAT Marks vs Rank")
            intent.putExtra("link","https://drive.google.com/uc?export=download&id=1P26NemkMTstU2MVv2kBhf6pzolmdK_69")
            startActivity(intent)
        }


    }
}