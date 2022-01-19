package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory implements ThreadFactory {
    public final boolean mAddThreadNumber;
    public final String mPrefix;
    public final AtomicInteger mThreadNumber = new AtomicInteger(1);
    public final int mThreadPriority;

    public PriorityThreadFactory(int i, String str, boolean z) {
        this.mThreadPriority = i;
        this.mPrefix = str;
        this.mAddThreadNumber = z;
    }

    public Thread newThread(final Runnable runnable) {
        String str;
        AnonymousClass1 r0 = new Runnable() {
            /* class com.facebook.imagepipeline.core.PriorityThreadFactory.AnonymousClass1 */

            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        };
        if (this.mAddThreadNumber) {
            str = this.mPrefix + "-" + this.mThreadNumber.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(r0, str);
    }
}
