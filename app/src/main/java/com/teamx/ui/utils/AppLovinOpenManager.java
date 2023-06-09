package com.teamx.ui.utils;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinOpenManager
        implements LifecycleObserver, MaxAdListener {
    private final MaxAppOpenAd appLovinOpenAd;
    private final Context context;

    //Ads ID here
    private final String ADS_UNIT = "f39f7b76863f8095";

    public AppLovinOpenManager(final Context context) {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        this.context = context;

        appLovinOpenAd = new MaxAppOpenAd(ADS_UNIT, context);
        appLovinOpenAd.setListener(this);
        appLovinOpenAd.loadAd();
    }

    private void showAdIfReady() {
        if (appLovinOpenAd == null || !AppLovinSdk.getInstance(context).isInitialized()) return;

        if (appLovinOpenAd.isReady()) {
            appLovinOpenAd.showAd(ADS_UNIT);
        } else {
            appLovinOpenAd.loadAd();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        showAdIfReady();
    }

    @Override
    public void onAdLoaded(final MaxAd ad) {
    }

    @Override
    public void onAdLoadFailed(final String adUnitId, final MaxError error) {
    }

    @Override
    public void onAdDisplayed(final MaxAd ad) {
    }

    @Override
    public void onAdClicked(final MaxAd ad) {
    }

    @Override
    public void onAdHidden(final MaxAd ad) {
        appLovinOpenAd.loadAd();
    }

    @Override
    public void onAdDisplayFailed(final MaxAd ad, final MaxError error) {
        appLovinOpenAd.loadAd();
    }
}
