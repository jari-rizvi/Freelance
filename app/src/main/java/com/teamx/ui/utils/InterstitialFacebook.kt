package com.teamx.ui.utils

import android.app.Activity
import android.util.Log
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxInterstitialAd
import com.applovin.sdk.AppLovinSdk
import java.util.*

class InterstitialFacebook {

    companion object {

        val TAG = "InterstitialFacebook"

        private var interstitialAd1: MaxInterstitialAd? = null

        fun loadInterstitialAppLovin(activity: Activity, AppLOvInId: String) {

            AppLovinSdk.getInstance(activity).getSettings()
                .setTestDeviceAdvertisingIds(Arrays.asList("YOUR_GAID_HERE"));
            AppLovinSdk.getInstance(activity).getSettings()
                .setTestDeviceAdvertisingIds(Arrays.asList("fd0d7a7c-986b-4324-b0a8-fecdc1ea9a52"));
            AppLovinSdk.getInstance(activity).setMediationProvider("max");
            if (AppLOvInId == "") {
                return
            }
            Log.d(TAG, AppLOvInId)

            if (interstitialAd1 == null) {
                Log.d(TAG, "loadAppLovin: loading")
                interstitialAd1 = MaxInterstitialAd(AppLOvInId, activity)
                interstitialAd1!!.loadAd()
            } else {
                Log.d(TAG, "loadAppLovin: loaded")
            }

        }

        fun showInterstitialAppLovin(
            onAdClosed: OnClosed,
            activity: Activity
        ) {

            if (interstitialAd1 != null) {
                if (interstitialAd1!!.isReady) {
                    interstitialAd1!!.showAd()
                    interstitialAd1!!.setListener(object : MaxAdListener {
                        override fun onAdLoaded(ad: MaxAd) {}
                        override fun onAdDisplayed(ad: MaxAd) {
                            Log.d(TAG, "onAdDisplayed")
                        }

                        override fun onAdHidden(ad: MaxAd) {
                            Log.d(TAG, "onAdHidden")
                            interstitialAd1 = null
                            onAdClosed.onAdClosed()

                            // Handle the error
                        }

                        override fun onAdClicked(ad: MaxAd) {}
                        override fun onAdLoadFailed(adUnitId: String, error: MaxError) {
                            Log.d(TAG, "facebookNativeAd$error")
                            interstitialAd1 = null
                            onAdClosed.onAdClosed()

                        }

                        override fun onAdDisplayFailed(ad: MaxAd, error: MaxError) {
                            Log.d(TAG, "error$error")
                            interstitialAd1 = null
                            onAdClosed.onAdClosed()

                        }
                    })
                } else {
                    Log.d(TAG, "notre")
                    onAdClosed.onAdClosed()
                }
            } else {
                Log.d(TAG, "null")
                onAdClosed.onAdClosed()
            }

        }

    }


}