/**MIT License

Copyright (c) 2024 Samyak Kamble

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.samyak2403.Control;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.samyak2403.Control.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class Control {

    private Activity activity;

    public Control(Activity activity) {
        this.activity = activity;
    }

    public void loadBannerAd(int linearLayoutId) {
        // Find the LinearLayout by its ID
        LinearLayout linearLayout = activity.findViewById(linearLayoutId);
        if (linearLayout != null) {
            AdView adView = new AdView(activity);
            adView.setAdUnitId(activity.getResources().getString(R.string.admob_banner_id));

            // Set adaptive banner size
            AdSize adSize = getAdSize();
            adView.setAdSize(adSize);

            linearLayout.addView(adView);
            adView.setAdListener(new AdListener() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
//                    Toast.makeText(activity, "Ad Failed", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                }

                @Override
                public void onAdOpened() {
                    super.onAdOpened();
                }

                @Override
                public void onAdSwipeGestureClicked() {
                    super.onAdSwipeGestureClicked();
                }

                @Override
                public int hashCode() {
                    return super.hashCode();
                }

                @Override
                public boolean equals(@Nullable Object obj) {
                    return super.equals(obj);
                }

                @NonNull
                @Override
                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }

                @NonNull
                @Override
                public String toString() {
                    return super.toString();
                }

                @Override
                protected void finalize() throws Throwable {
                    super.finalize();
                }
            });
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        } else {
            Toast.makeText(activity, "LinearLayout not found", Toast.LENGTH_SHORT).show();
        }
    }

    private AdSize getAdSize() {
        // Determine the screen width (less decorations) to use for the ad width.
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        float density = outMetrics.density;

        float adWidthPixels = outMetrics.widthPixels;
        int adWidth = (int) (adWidthPixels / density);

        // Return the ad size.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }
}