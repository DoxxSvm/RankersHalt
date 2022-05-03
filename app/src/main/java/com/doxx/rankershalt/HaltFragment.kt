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
            var whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.setType("text/plain")
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share")
            try {
                startActivity(whatsappIntent)
            } catch (ex: ActivityNotFoundException){
                Toast.makeText(context,"Unable to Share",Toast.LENGTH_SHORT).show()
            }
        }
        haltRating.setOnClickListener{
            Toast.makeText(context,"Coming Soon",Toast.LENGTH_SHORT).show()
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