package com.bugsnag.android;

import android.os.HandlerThread;

/* compiled from: AnrDetailsCollector.kt */
public final class AnrDetailsCollector {
    public final HandlerThread handlerThread;

    public AnrDetailsCollector() {
        HandlerThread handlerThread2 = new HandlerThread("bugsnag-anr-collector");
        this.handlerThread = handlerThread2;
        handlerThread2.start();
    }
}
