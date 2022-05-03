package com.doxx.rankershalt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_view_book.*
import kotlinx.android.synthetic.main.fragment_jee_materials.*


class ViewBook : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_book)
        var doxx = Doxx()
        doxx.setStatusBarGradiant(this)
        var pdfView = findViewById<PDFView>(R.id.pdfView22)
        val bundle: Bundle? = intent.extras
        var fileName = bundle?.getString("Filename").toString()
        loadAds()
        if(fileName=="null"){
            pdfView.fromAsset("rh_ptable.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableAntialiasing(true)
                .spacing(0)
                .scrollHandle(DefaultScrollHandle(this))
                .enableAnnotationRendering(true)
                .load()
        }
        else{
            pdfView.fromFile(getFileStreamPath(fileName))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableAntialiasing(true)
                .spacing(0)
                .scrollHandle(DefaultScrollHandle(this))
                .enableAnnotationRendering(true)
                .load()


        }



    }
    fun loadAds(){
        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        ViewBookadView.loadAd(adRequest)
        ViewBookadView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }
        }


    }



}