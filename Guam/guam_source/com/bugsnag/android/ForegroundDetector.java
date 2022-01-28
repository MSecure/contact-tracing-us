package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;

public class ForegroundDetector {
    public final ActivityManager activityManager;

    public ForegroundDetector(Context context) {
        this.activityManager = (ActivityManager) context.getSystemService("activity");
    }
}
