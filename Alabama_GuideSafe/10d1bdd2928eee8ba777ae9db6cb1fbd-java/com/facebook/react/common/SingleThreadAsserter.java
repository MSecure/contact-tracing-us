package com.facebook.react.common;

import androidx.appcompat.app.AppCompatDelegateImpl;

public class SingleThreadAsserter {
    public Thread mThread = null;

    public void assertNow() {
        Thread currentThread = Thread.currentThread();
        if (this.mThread == null) {
            this.mThread = currentThread;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mThread == currentThread);
    }
}
