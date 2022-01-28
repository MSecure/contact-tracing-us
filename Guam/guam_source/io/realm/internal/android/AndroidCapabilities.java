package io.realm.internal.android;

import android.os.Looper;
import io.realm.internal.Capabilities;

public class AndroidCapabilities implements Capabilities {
    public final boolean isIntentServiceThread;
    public final Looper looper = Looper.myLooper();

    public AndroidCapabilities() {
        String name = Thread.currentThread().getName();
        this.isIntentServiceThread = name != null && name.startsWith("IntentService[");
    }

    public boolean canDeliverNotification() {
        return (this.looper != null) && !this.isIntentServiceThread;
    }
}
