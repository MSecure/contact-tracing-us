package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.HashSet;
import java.util.Set;

public class DeferredReleaser {
    public static DeferredReleaser sInstance;
    public final Set<Releasable> mPendingReleasables = new HashSet();
    public final Handler mUiHandler = new Handler(Looper.getMainLooper());
    public final Runnable releaseRunnable = new Runnable() {
        /* class com.facebook.drawee.components.DeferredReleaser.AnonymousClass1 */

        public void run() {
            DeferredReleaser.ensureOnUiThread();
            for (Releasable releasable : DeferredReleaser.this.mPendingReleasables) {
                releasable.release();
            }
            DeferredReleaser.this.mPendingReleasables.clear();
        }
    };

    public interface Releasable {
        void release();
    }

    public static void ensureOnUiThread() {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    public void cancelDeferredRelease(Releasable releasable) {
        ensureOnUiThread();
        this.mPendingReleasables.remove(releasable);
    }
}
