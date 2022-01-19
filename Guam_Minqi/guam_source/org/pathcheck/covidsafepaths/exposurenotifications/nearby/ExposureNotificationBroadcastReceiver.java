package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;

public class ExposureNotificationBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED".equals(action) || "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND".equals(action)) {
            WorkManagerImpl.getInstance(context).enqueue(new OneTimeWorkRequest.Builder(StateUpdatedWorker.class).build());
        }
    }
}
