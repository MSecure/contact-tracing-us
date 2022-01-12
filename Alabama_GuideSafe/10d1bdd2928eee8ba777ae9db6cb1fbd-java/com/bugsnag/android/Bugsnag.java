package com.bugsnag.android;

import android.annotation.SuppressLint;

public final class Bugsnag {
    @SuppressLint({"StaticFieldLeak"})
    public static Client client;
    public static final Object lock = new Object();

    public static Client getClient() {
        Client client2 = client;
        if (client2 != null) {
            return client2;
        }
        throw new IllegalStateException("You must call Bugsnag.start before any other Bugsnag methods");
    }
}
