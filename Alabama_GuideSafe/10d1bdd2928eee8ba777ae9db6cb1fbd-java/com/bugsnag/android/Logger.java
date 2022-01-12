package com.bugsnag.android;

/* compiled from: Logger.kt */
public interface Logger {
    void d(String str);

    void e(String str);

    void e(String str, Throwable th);

    void i(String str);

    void w(String str);

    void w(String str, Throwable th);
}
