package com.doxx.rankershalt

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        StatusBarColor.setStatusBarGradiant(this)
        bottomNav2.setOnItemSelectedListener {
                itemId -> bottomNav.selectedItemId = itemId
        }
        val navHomeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController  = navHomeFragment.navController
        bottomNav.setupWithNavController(navController)
        bottomNav2.setItemSelected(R.id.homeFragment2)
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