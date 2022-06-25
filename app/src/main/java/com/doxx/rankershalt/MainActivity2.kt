package com.doxx.rankershalt

import android.annotation.TargetApi
import android.app.Activity
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import kotlinx.android.synthetic.main.activity_main2.*
class MainActivity2 : AppCompatActivity() {
    private var appUpdate:AppUpdateManager?=null
    private val REQ=100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        appUpdate=AppUpdateManagerFactory.create(this)
        checkUpdate()
        StatusBarColor.setStatusBarGradiant(this)

        bottomNav2.setOnItemSelectedListener {
                itemId -> bottomNav.selectedItemId = itemId
        }
        val navHomeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController  = navHomeFragment.navController
        bottomNav.setupWithNavController(navController)
        bottomNav2.setItemSelected(R.id.homeFragment2)


    }
    private fun checkUpdate(){
        appUpdate?.appUpdateInfo?.addOnSuccessListener {
            if(it.updateAvailability()==UpdateAvailability.UPDATE_AVAILABLE
                && it.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)){
                appUpdate?.startUpdateFlowForResult(it,AppUpdateType.IMMEDIATE,this,REQ)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        inProgressUpdate()
    }
    private fun inProgressUpdate(){
        appUpdate?.appUpdateInfo?.addOnSuccessListener {
            if(it.updateAvailability()==UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS){
                appUpdate?.startUpdateFlowForResult(it,AppUpdateType.IMMEDIATE,this,REQ)
            }
        }
    }
}
class StatusBarColor{
    companion object{
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        fun setStatusBarGradiant(activity: Activity) {

            val window: Window = activity.window
            val background = ContextCompat.getDrawable(activity, R.drawable.gradient)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            window.statusBarColor = ContextCompat.getColor(activity,android.R.color.transparent)
            window.navigationBarColor = ContextCompat.getColor(activity,android.R.color.transparent)
            window.setBackgroundDrawable(background)

        }
    }
}