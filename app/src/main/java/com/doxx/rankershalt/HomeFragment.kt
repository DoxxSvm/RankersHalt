package com.doxx.rankershalt

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Secure.getString
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home2.*
import kotlin.Exception


class HomeFragment : Fragment(R.layout.fragment_home2) {

    private var ID:String?="Hii"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try{
            checkID()
            fhomeshareText.text=getString(R.string.share, ID)
        }
        catch (e:Exception){
            ID="QAZWSX3E"
            fhomeshareText.text=getString(R.string.share, ID)
        }
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
                intent.putExtra(Intent.EXTRA_TEXT,"Hey! improve your rank using this amazing app." +
                        " https://play.google.com/store/apps/details?id=com.doxx.rankershalt" +" My RankersID is " +ID)
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
        fhomeclaim.setOnClickListener {
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
        fhometele.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/+wL0Ik29IunQzMTFl"))
                intent.setPackage("org.telegram.messenger")
                startActivity(intent)
            }
            catch (e:Exception){
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        fhomeinfo.setOnClickListener{
            showDialog()
        }
        fhomeplaystore.setOnClickListener {
            copyTextToClipboard(1)
        }
        fhomeshareText.setOnClickListener {
            copyTextToClipboard(0)
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

    private fun checkID() {
        val sharedPreferences = requireActivity().getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        ID = sharedPreferences.getString("ID",null)
        if(ID.equals(null)){
            val editor = sharedPreferences.edit()
            editor.apply{
                putString("ID",getRankersID())
            }.apply()
            ID = sharedPreferences.getString("ID",null).toString()
        }
    }
    private fun getRankersID() : String {
        val id = getString(requireActivity().contentResolver, Settings.Secure.ANDROID_ID)

        val subs = id.subSequence(1,7)
        var rId=subs
        if(subs[0].isDigit()){
            rId=((subs[0].toString().toInt() +3)%10).toString() + rId
        }
        else{
            rId = (((subs[0].uppercaseChar().toInt()-65)+3)%26+65).toChar().toString()+rId
        }
        if(subs[5].isDigit()){
            rId += ((subs[5].toString().toInt() + 3) % 10).toString()
        }
        else{

            rId += (((subs[5].uppercaseChar().toInt()-65)+3)%26+65).toChar().toString()
        }
        return rId
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