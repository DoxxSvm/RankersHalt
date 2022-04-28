package com.doxx.rankershalt

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.android.synthetic.main.fragment_neet_materials.*


class NeetMaterialsFragment : Fragment(R.layout.fragment_neet_materials) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MobileAds.initialize(context){};
        val adLoader = AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110")
            .forNativeAd { ad : NativeAd ->
                val style = NativeTemplateStyle.Builder().withMainBackgroundColor(ColorDrawable(Color.WHITE)).build()
                my_template.setStyles(style)
                my_template.setNativeAd(ad)
                if (requireActivity().isDestroyed) {
                    ad.destroy()
                    return@forNativeAd
                }

            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}