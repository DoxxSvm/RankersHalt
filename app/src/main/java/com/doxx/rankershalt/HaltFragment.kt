package com.doxx.rankershalt

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.play.core.review.ReviewManagerFactory
import kotlinx.android.synthetic.main.fragment_halt.*
import java.lang.Exception


class HaltFragment : Fragment(R.layout.fragment_halt) {
    @SuppressLint("ClickableViewAccessibility")
    private var ID:String?="Hii"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkID()
        haltshareText.text=getString(R.string.share, ID)
        haltshare.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey! improve your rank using this amazing app " +
                    "https://play.google.com/store/apps/details?id=com.doxx.rankershalt")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
        }
        haltplaystore.setOnClickListener {
            copyTextToClipboard(1)
        }
        haltshareText.setOnClickListener {
            copyTextToClipboard(0)
        }
        haltinfo.setOnClickListener {
            showDialog()
        }
        haltclaim.setOnClickListener {
            try{
                val to = "support@rankershalt.com"
                val subject = "Claim Reward"
                val body="Enter RankersID of your 5 friends"
                val mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(body)
                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.data = Uri.parse(mailTo)
                emailIntent.setPackage("com.google.android.gm");
                startActivity(emailIntent)
            }
            catch (e :Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        haltRating.setOnTouchListener(View.OnTouchListener { v, event ->
            try {
                if (event.action == MotionEvent.ACTION_UP) {
                    inAppReview()
                }
            }
            catch (e :Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
            return@OnTouchListener true
        })

        haltrequest.setOnClickListener {
            try{
                val to = "support@rankershalt.com"
                val subject = "Book Request"
                val mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject)
                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.data = Uri.parse(mailTo)
                emailIntent.setPackage("com.google.android.gm");
                startActivity(emailIntent)
            }
            catch (e :Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        haltcontri.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.buymeacoffee.com/rankershalt"))
            startActivity(browserIntent)
        }
        haltcontactus.setOnClickListener {
            try{
                val to = "support@rankershalt.com"
                val subject = "Help/Support"
                val mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject)
                val emailIntent = Intent(Intent.ACTION_VIEW)
                emailIntent.data = Uri.parse(mailTo)
                emailIntent.setPackage("com.google.android.gm");
                startActivity(emailIntent)
            }
            catch (e :Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun inAppReview() {
        val reviewManager = context?.let { ReviewManagerFactory.create(it) }
        val requestReviewFlow = reviewManager?.requestReviewFlow()
        requestReviewFlow?.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                // We got the ReviewInfo object
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(requireActivity(), reviewInfo)
                flow.addOnCompleteListener {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                }
            } else {
                Log.d("Error: ", request.exception.toString())
                // There was some problem, continue regardless of the result.
            }
        }
    }
    private fun checkID() {
        val sharedPreferences = requireActivity().getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
       ID = sharedPreferences.getString("ID",null)
    }
    private fun showDialog() {
        val dialog = context?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)
        dialog?.setContentView(R.layout.info)

        if (dialog != null) {
            dialog.show()
        }

    }
    private fun copyTextToClipboard(a: Int) {
        var textToCopy: String?
        if (a==1){
            textToCopy ="https://play.google.com/store/apps/details?id=com.doxx.rankershalt"
        }
        else textToCopy = ID
        val clipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)

        if(a==1) Toast.makeText(context, "Download Link copied to clipboard", Toast.LENGTH_LONG).show()
        else Toast.makeText(context, "RankersID copied to clipboard", Toast.LENGTH_LONG).show()
    }
}