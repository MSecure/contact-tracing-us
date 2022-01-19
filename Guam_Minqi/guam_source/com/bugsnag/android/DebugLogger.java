package com.bugsnag.android;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugLogger.kt */
public final class DebugLogger implements Logger {
    public static final DebugLogger INSTANCE = new DebugLogger();

    @Override // com.bugsnag.android.Logger
    public void d(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Log.e("Bugsnag", str);
    }

    @Override // com.bugsnag.android.Logger
    public void i(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Log.i("Bugsnag", str);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Log.w("Bugsnag", str);
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        Log.e("Bugsnag", str, th);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        Log.w("Bugsnag", str, th);
    }
}
