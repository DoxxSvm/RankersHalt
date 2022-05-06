package com.doxx.rankershalt

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_halt.*


class HaltFragment : Fragment(R.layout.fragment_halt) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        haltshare.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey! improve your rank using this amazing app " +
                    "https://play.google.com/store/apps/details?id=com.doxx.rankershalt")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
        }
        haltRating.setOnClickListener{
            val uri = Uri.parse("market://details?id=com.doxx.rankershalt")
            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
            startActivity(myAppLinkToMarket)
            Toast.makeText(context, "Hii", Toast.LENGTH_SHORT).show()
        }
        haltrequest.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:support@rankershalt.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Request"))
        }
        haltcontri.setOnClickListener {
            Toast.makeText(context,"Coming Soon",Toast.LENGTH_SHORT).show()
        }
    }
}