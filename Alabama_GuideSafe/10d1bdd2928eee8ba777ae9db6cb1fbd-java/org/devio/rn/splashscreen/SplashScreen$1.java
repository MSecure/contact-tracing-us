package org.devio.rn.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import com.google.common.util.concurrent.MoreExecutors;

public final class SplashScreen$1 implements Runnable {
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ int val$themeResId;

    public SplashScreen$1(Activity activity, int i) {
        this.val$activity = activity;
        this.val$themeResId = i;
    }

    public void run() {
        if (!this.val$activity.isFinishing()) {
            Dialog dialog = new Dialog(this.val$activity, this.val$themeResId);
            MoreExecutors.mSplashDialog = dialog;
            dialog.setContentView(R$layout.launch_screen);
            MoreExecutors.mSplashDialog.setCancelable(false);
            if (!MoreExecutors.mSplashDialog.isShowing()) {
                MoreExecutors.mSplashDialog.show();
            }
        }
    }
}
