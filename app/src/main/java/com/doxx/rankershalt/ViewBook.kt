package com.doxx.rankershalt

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.File


class ViewBook : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_book)
        var doxx = Doxx()
        doxx.setStatusBarGradiant(this)
        var pdfView = findViewById<PDFView>(R.id.pdfView22)
        val bundle: Bundle? = intent.extras
        var fileName = bundle?.getString("Filename").toString()
        //bottomNav2.showBadge(R.id.downloadsFragment)

        pdfView.fromFile(getFileStreamPath(fileName))
            .enableSwipe(true)
            .swipeHorizontal(false)
            .onError { t: Throwable ->
                Log.e(
                    "file",
                    "file$t"
                )
            }
            .enableAntialiasing(true)
            .spacing(0)
            .scrollHandle(DefaultScrollHandle(this))
            .enableAnnotationRendering(true)
            .load()
    }



}