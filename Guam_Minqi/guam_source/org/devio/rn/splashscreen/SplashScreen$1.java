package org.devio.rn.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import com.horcrux.svg.PathParser;

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
            PathParser.mSplashDialog = dialog;
            dialog.setContentView(R$layout.launch_screen);
            PathParser.mSplashDialog.setCancelable(false);
            if (!PathParser.mSplashDialog.isShowing()) {
                PathParser.mSplashDialog.show();
            }
        }
    }
}
