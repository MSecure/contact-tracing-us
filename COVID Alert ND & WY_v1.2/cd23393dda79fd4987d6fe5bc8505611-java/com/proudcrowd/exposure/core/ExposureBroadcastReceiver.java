package com.proudcrowd.exposure.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;

public final class ExposureBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ExposureNotificationClient.ACTION_EXPOSURE_STATE_UPDATED.equals(action) || ExposureNotificationClient.ACTION_EXPOSURE_NOT_FOUND.equals(action)) {
            ExposureMatchManager.runOnce(context);
        }
    }
}
