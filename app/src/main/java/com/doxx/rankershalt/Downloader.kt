package com.doxx.rankershalt

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_downloader.*
import kotlinx.android.synthetic.main.fragment_jee_materials.*
import java.text.DecimalFormat


class Downloader : AppCompatActivity() {
    var name="helo"
    private val df = DecimalFormat("0.00")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloader)
        loadAds()
        val link = intent.getStringExtra("link")
        val a = intent.getStringExtra("title")
        var flag = false
        if(a!=null){
            name =a
        }
        DownloaderTitle.text=name
        val file = filesDir.listFiles()
        for (i in file.indices) {
            if (file.get(i).toString().contains(name)) {
                buttonDownload.setText("open")
                flag = true
            }
        }
        buttonDownload.setOnClickListener {
            if(flag==true){
                var intent = Intent(applicationContext,ViewBook::class.java)
                intent.putExtra("Filename",name)
                startActivity(intent)
            }
            else if(link!=null){
                startDownload(link)
            }
        }
    }
    fun startDownload(url:String){
        var downloadId=0
        val dialog = ProgressDialog(this)
        dialog.setTitle("Downloading")
        dialog.setMessage("Preparing...")
        dialog.setCancelable(false)
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"cancel",
        DialogInterface.OnClickListener{
            dialog,which->
            dialog.dismiss()
            PRDownloader.cancel(downloadId)
        })
        dialog.show()
        val config = PRDownloaderConfig.newBuilder()
            .setDatabaseEnabled(true)
            .build()
        PRDownloader.initialize(applicationContext, config)
        downloadId = PRDownloader.download(url, filesDir.absolutePath,name)
            .build()
            .setOnStartOrResumeListener {
                dialog.setTitle("Download Started")
            }
            .setOnPauseListener { }
            .setOnCancelListener {
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show()
            }
            .setOnProgressListener {
                val percent = it.currentBytes*100/it.totalBytes
                dialog.progress=percent.toInt()
                val current = df.format(it.currentBytes/1024/1024.0)
                val total = df.format(it.totalBytes/1024/1024.0)
                dialog.setMessage(current.toString()+"MB/"+total+"MB")
            }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    Toast.makeText(this@Downloader,"Download Completed",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    var intent = Intent(applicationContext,ViewBook::class.java)
                    intent.putExtra("Filename",name)
                    startActivity(intent)

                }
                override fun onError(error: com.downloader.Error?) {
                    Toast.makeText(this@Downloader, "Retrying", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    startDownload(url)
                }

            })
    }
    fun loadAds(){
        MobileAds.initialize(applicationContext) {}

        val adRequest = AdRequest.Builder().build()
        downloaderadView.loadAd(adRequest)
        downloaderadView.adListener = object: AdListener() {
            override fun onAdLoaded() {

            }

            override fun onAdFailedToLoad(adError : LoadAdError) {// Code to be executed when an ad request fails.
            }

        }
    }
}