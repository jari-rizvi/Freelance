package com.teamx.ui.utils

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdViewAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView
import com.facebook.ads.*

class BannerFacebook {


    val TAG = "BannerFacebook"

    private var adViewLovIn: MaxAdView? = null

    fun loadAppLovInBanner(
        activity: Activity,
        adContainer: FrameLayout,
        bannerId: String
    ) {


            if (bannerId == "") {
                return
            }
            adViewLovIn = MaxAdView(bannerId, activity)
            adContainer.removeAllViews()
            adContainer.addView(adViewLovIn)
            adViewLovIn!!.loadAd()
            adViewLovIn!!.setListener(object : MaxAdViewAdListener {
                override fun onAdExpanded(ad: MaxAd) {}
                override fun onAdCollapsed(ad: MaxAd) {
                    Log.d(TAG, "onAdCollapsed: ")
                }

                override fun onAdLoaded(ad: MaxAd) {
                    Log.d(TAG, "onAdLoaded: ")
                    adContainer.visibility = View.VISIBLE
                }

                override fun onAdDisplayed(ad: MaxAd) {

                }

                override fun onAdHidden(ad: MaxAd) {}
                override fun onAdClicked(ad: MaxAd) {}
                override fun onAdLoadFailed(adUnitId: String, error: MaxError) {
                    adContainer.visibility = View.GONE
                    Log.d(TAG, "onAdLoadFailed: $error")
                }

                override fun onAdDisplayFailed(ad: MaxAd, error: MaxError) {
                    adContainer.visibility = View.GONE
                    Log.d(TAG, "onAdDisplayFailed: ")
                }
            })
        }

}