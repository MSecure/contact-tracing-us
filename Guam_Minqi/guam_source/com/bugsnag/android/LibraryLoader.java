package com.bugsnag.android;

import java.util.concurrent.atomic.AtomicBoolean;

public class LibraryLoader {
    public AtomicBoolean attemptedLoad = new AtomicBoolean();

    public boolean loadLibrary(String str, Client client, OnErrorCallback onErrorCallback) {
        if (this.attemptedLoad.getAndSet(true)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            client.notify(e, onErrorCallback);
            return false;
        }
    }
}
