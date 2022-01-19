package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class SnackbarManager {
    public static SnackbarManager snackbarManager;
    public final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        /* class com.google.android.material.snackbar.SnackbarManager.AnonymousClass1 */

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager snackbarManager = SnackbarManager.this;
            SnackbarRecord snackbarRecord = (SnackbarRecord) message.obj;
            synchronized (snackbarManager.lock) {
                if (snackbarRecord == null) {
                    Callback callback = snackbarRecord.callback.get();
                    if (callback != null) {
                        snackbarManager.handler.removeCallbacksAndMessages(snackbarRecord);
                        callback.dismiss(2);
                    }
                }
            }
            return true;
        }
    });
    public final Object lock = new Object();

    public interface Callback {
        void dismiss(int i);
    }

    public static class SnackbarRecord {
        public final WeakReference<Callback> callback;
    }
}
