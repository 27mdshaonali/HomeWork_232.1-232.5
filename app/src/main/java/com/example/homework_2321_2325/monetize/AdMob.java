package com.example.homework_2321_2325.monetize;

import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AdMob {

    public static void sdkInitialize(Context context) {

        if (!Constant.IS_AD_ENABLE) return;


        new Thread(() -> {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(context, initializationStatus -> {
            });
        }).start();

    }

    public static void showBannerAd(LinearLayout adContainerView, Context context) {
        if (!Constant.IS_AD_ENABLE) return;

        AdView adView = new AdView(context);

        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(Constant.BANNER_AD);

        // Replace ad container with new ad view.
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

        // Start loading the ad in the background.
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }


}
