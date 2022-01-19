package org.devio.rn.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import com.horcrux.svg.PathParser;

public final class SplashScreen$2 implements Runnable {
    public final /* synthetic */ Activity val$_activity;

    public SplashScreen$2(Activity activity) {
        this.val$_activity = activity;
    }

    public void run() {
        Dialog dialog = PathParser.mSplashDialog;
        if (dialog != null && dialog.isShowing()) {
            boolean isDestroyed = this.val$_activity.isDestroyed();
            if (!this.val$_activity.isFinishing() && !isDestroyed) {
                PathParser.mSplashDialog.dismiss();
            }
            PathParser.mSplashDialog = null;
        }
    }
}
