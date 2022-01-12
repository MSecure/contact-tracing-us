package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigChangeReceiver.kt */
public final class ConfigChangeReceiver extends BroadcastReceiver {
    public final Function2<String, String, Unit> cb;
    public final DeviceDataCollector deviceDataCollector;
    public String orientation;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public ConfigChangeReceiver(DeviceDataCollector deviceDataCollector2, Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(deviceDataCollector2, "deviceDataCollector");
        Intrinsics.checkParameterIsNotNull(function2, "cb");
        this.deviceDataCollector = deviceDataCollector2;
        this.cb = function2;
        this.orientation = deviceDataCollector2.calculateOrientation$bugsnag_android_core_release();
    }

    public void onReceive(Context context, Intent intent) {
        String calculateOrientation$bugsnag_android_core_release = this.deviceDataCollector.calculateOrientation$bugsnag_android_core_release();
        String str = this.orientation;
        boolean z = false;
        if (calculateOrientation$bugsnag_android_core_release != null) {
            z = calculateOrientation$bugsnag_android_core_release.equals(str);
        } else if (str == null) {
            z = true;
        }
        if (!z) {
            this.cb.invoke(this.orientation, calculateOrientation$bugsnag_android_core_release);
            this.orientation = calculateOrientation$bugsnag_android_core_release;
        }
    }
}
