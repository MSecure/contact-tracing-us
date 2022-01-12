package org.devio.rn.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import com.google.common.util.concurrent.MoreExecutors;

public final class SplashScreen$2 implements Runnable {
    public final /* synthetic */ Activity val$_activity;

    public SplashScreen$2(Activity activity) {
        this.val$_activity = activity;
    }

    public void run() {
        Dialog dialog = MoreExecutors.mSplashDialog;
        if (dialog != null && dialog.isShowing()) {
            boolean isDestroyed = this.val$_activity.isDestroyed();
            if (!this.val$_activity.isFinishing() && !isDestroyed) {
                MoreExecutors.mSplashDialog.dismiss();
            }
            MoreExecutors.mSplashDialog = null;
        }
    }
}
